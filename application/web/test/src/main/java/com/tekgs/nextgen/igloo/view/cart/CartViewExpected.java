package com.tekgs.nextgen.igloo.view.cart;

import com.tekgs.nextgen.igloo.data.cart.CartCalibratable;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.view.cart.items.CartItemsRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartViewExpected implements CartViewCalibratable {
    private final CartCalibratable cart;

    private CartViewExpected(CartCalibratable cart) {
        this.cart = cart;
    }

    public static CartViewExpected getInstance(CartCalibratable cart) {
        return new CartViewExpected(cart);
    }

    public static CartViewExpected getInstance() {
        return new CartViewExpected(null);
    }

    @Override
    public Boolean isPaymentEnabled() {
        return getTotalInDollars() > 0;
    }

    @Override
    public String getTotalFormatted() {
        return String.format("$%.2f", getTotalInDollars());
    }

    private float getTotalInDollars() {
        if (cart == null) {
            return 0;
        }
        int total = cart.getItems().stream().reduce(0, (prev, item) -> prev + item.getPrice(), Integer::sum);
        return (float) total / 100;
    }

    @Override
    public CartItemsRegionExpected inCartItemsRegion() {
        List<CartItemCalibratable> items = cart == null ? new ArrayList<>() : cart.getItems();
        return CartItemsRegionExpected.getInstance(items);
    }
}
