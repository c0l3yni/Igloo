package com.tekgs.nextgen.igloo.data.cart.item;

import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;

public class CartItemDefinition implements CartItemCalibratable {
    private ProductCalibratable product;
    private Integer quantity;

    public static CartItemDefinition getInstance() {
        return new CartItemDefinition();
    }

    public CartItemDefinition withProduct(ProductCalibratable product) {
        this.product = product;
        return this;
    }

    public CartItemDefinition withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
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
