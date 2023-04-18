package com.tekgs.nextgen.igloo.view.cart;

import com.tekgs.nextgen.igloo.data.cart.Cart;
import com.tekgs.nextgen.igloo.data.cart.CartCalibratable;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cart;
    private final List<CartItemCalibratable> items;

    protected CartExpected(CartCalibratable cart, List<CartItemCalibratable> cartItems) {
        this.cart = cart;
        this.items = cartItems == null ? cart.getItems() : cartItems;
    }

    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart, null);
    }

    public static CartExpected getInstance(Cart cart, List<CartItemCalibratable> cartItems) {
        return new CartExpected(cart, cartItems);
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
    }

    @Override
    public String getId() {
        return cart.getId();
    }
}
