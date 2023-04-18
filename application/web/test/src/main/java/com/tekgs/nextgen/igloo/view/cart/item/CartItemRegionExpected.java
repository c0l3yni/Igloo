package com.tekgs.nextgen.igloo.view.cart.item;

import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegionCalibratable;
import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegionExpected;

public class CartItemRegionExpected implements CartItemRegionCalibratable {
    private final CartItemCalibratable item;

    public CartItemRegionExpected(CartItemCalibratable item) {
        this.item = item;
    }

    public static CartItemRegionExpected getInstance(CartItemCalibratable item) {
        return new CartItemRegionExpected(item);
    }

    @Override
    public String getItemDescription() {
        return item.getDescription();
    }

    @Override
    public boolean equivalent(CartItemRegionCalibratable comparator) {
        return false;
    }

    @Override
    public Integer getQuantity() {
        return item.getQuantity();
    }

    @Override
    public Integer getPrice() {
        return item.getPrice();
    }

    @Override
    public Boolean isIncrementButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isDecrementButtonDisplayed() {
        return true;
    }

    @Override
    public ProductRegionCalibratable inProductRegion() {
        return ProductRegionExpected.getInstance(item.getProduct());
    }

}
