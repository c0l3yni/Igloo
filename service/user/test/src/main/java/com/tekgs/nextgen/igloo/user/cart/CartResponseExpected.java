package com.tekgs.nextgen.igloo.user.cart;

import java.util.ArrayList;
import java.util.List;

public class CartResponseExpected implements CartResponseCalibratable {
    @SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
    private final List<CartCalibratable> carts = new ArrayList<>();

    public CartResponseExpected(List<CartCalibratable> carts) {
        this.carts.addAll(carts);
    }

    public static CartResponseExpected getInstance() {
        return new CartResponseExpected(new ArrayList<>());
    }
}
