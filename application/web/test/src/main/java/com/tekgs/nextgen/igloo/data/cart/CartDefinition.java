package com.tekgs.nextgen.igloo.data.cart;

import com.tekgs.nextgen.igloo.behavior.ToStringBehavior;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<CartItemCalibratable> items = new ArrayList<>();
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);
    @SuppressWarnings("unused")
    private String id;

    public static CartDefinition getInstance() {
        return new CartDefinition();
    }

    public CartDefinition withItem(CartItemCalibratable definition) {
        getItems().add(definition);
        return this;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
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
