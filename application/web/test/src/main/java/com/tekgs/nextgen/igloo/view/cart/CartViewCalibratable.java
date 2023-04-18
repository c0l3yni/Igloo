package com.tekgs.nextgen.igloo.view.cart;

import com.tekgs.nextgen.igloo.view.cart.items.CartItemsRegionCalibratable;

public interface CartViewCalibratable {
    Boolean isPaymentEnabled();

    String getTotalFormatted();

    CartItemsRegionCalibratable inCartItemsRegion();
}
