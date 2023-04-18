package com.tekgs.nextgen.igloo.data.cart.item;

import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;

public interface CartItemCalibratable {
    Integer getPrice();

    String getDescription();

    Integer getQuantity();

    ProductCalibratable getProduct();

    boolean equivalent(CartItemCalibratable comparator);
}
