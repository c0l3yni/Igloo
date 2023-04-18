package com.tekgs.nextgen.igloo.data.cart;

import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    List<CartItemCalibratable> getItems();

    String getId();

    String toString();
}
