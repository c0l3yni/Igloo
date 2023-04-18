package com.tekgs.nextgen.igloo.view.cart.item;

import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegionCalibratable;

public interface CartItemRegionCalibratable {

    String getItemDescription();

    boolean equivalent(CartItemRegionCalibratable comparator);

    Integer getQuantity();

    Integer getPrice();

    Boolean isIncrementButtonDisplayed();

    Boolean isDecrementButtonDisplayed();

    ProductRegionCalibratable inProductRegion();
}
