package com.tekgs.nextgen.igloo.data.cart;

import com.tekgs.nextgen.igloo.behavior.ToStringBehavior;
import com.tekgs.nextgen.igloo.data.cart.item.CartItem;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<CartItem> items = new ArrayList<>();
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String id;

    public boolean equivalent(CartCalibratable definition) {
        if (definition != null && this.getId().equals(definition.getId())) {
            return true;
        }
        boolean isEquivalent = true;
        List<CartItemCalibratable> thisItems = new ArrayList<>(this.getItems());
        //noinspection ConstantConditions
        for (CartItemCalibratable itemDefinition : definition.getItems()) {
            CartItemCalibratable foundItem = null;
            for (CartItemCalibratable candidate : thisItems) {
                if (candidate.equivalent(itemDefinition)) {
                    foundItem = candidate;
                    break;
                }
            }
            if (foundItem == null) {
                isEquivalent = false;
                break;
            } else {
                thisItems.remove(foundItem);
            }
        }
        return isEquivalent;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return toStringBehavior.execute();
    }
}
