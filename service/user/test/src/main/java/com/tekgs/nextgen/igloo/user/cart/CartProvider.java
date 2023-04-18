package com.tekgs.nextgen.igloo.user.cart;

import java.util.ArrayList;
import java.util.List;

public class CartProvider {
    private CartProvider() {
    }

    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public List<CartCalibratable> get() {
        return new ArrayList<>();
    }
}
