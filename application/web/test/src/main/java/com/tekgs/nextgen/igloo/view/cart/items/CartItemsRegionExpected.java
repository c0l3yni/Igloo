package com.tekgs.nextgen.igloo.view.cart.items;

import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegionCalibratable;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegionExpected implements CartItemsRegionCalibratable {
    private final List<CartItemRegionCalibratable> items = new ArrayList<>();

    public CartItemsRegionExpected(List<CartItemCalibratable> items) {
        for (CartItemCalibratable item : items) {
            this.items.add(CartItemRegionExpected.getInstance(item));
        }
    }

    public static CartItemsRegionExpected getInstance(List<CartItemCalibratable> items) {
        return new CartItemsRegionExpected(items);
    }

    @Override
    public List<CartItemRegionCalibratable> getItems() {
        return items;
    }
}
