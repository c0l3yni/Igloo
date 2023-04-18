package com.tekgs.nextgen.igloo.data.cart.item;

import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;

public class CartItemExpected implements CartItemCalibratable {
    private final Integer quantity;
    private final ProductCalibratable product;

    private CartItemExpected(ProductCalibratable product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public static CartItemExpected getInstance(ProductCalibratable product, int quantity) {
        return new CartItemExpected(product, quantity);
    }

    @Override
    public Integer getPrice() {
        return product == null ? 0 : product.getPrice();
    }

    @Override
    public String getDescription() {
        return product == null ? null : product.getDescription();
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public ProductCalibratable getProduct() {
        return product;
    }

    @Override
    public boolean equivalent(CartItemCalibratable comparator) {
        return false;
    }
}
