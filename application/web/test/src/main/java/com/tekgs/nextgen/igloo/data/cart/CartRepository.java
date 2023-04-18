package com.tekgs.nextgen.igloo.data.cart;

import java.util.List;

public class CartRepository {
    public static CartRepository getInstance() {
        return new CartRepository();
    }

    public Cart query(CartCalibratable definition) {
        for (Cart candidate : getCarts()) {
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }

    private List<Cart> getCarts() {
        return CartRequest.getInstance().get().getCarts();
    }
}
