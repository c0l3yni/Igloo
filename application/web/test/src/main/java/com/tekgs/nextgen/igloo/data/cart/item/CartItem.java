package com.tekgs.nextgen.igloo.data.cart.item;

import com.tekgs.nextgen.igloo.data.product.Product;

public class CartItem implements CartItemCalibratable {
    private final Product product;
    private final int quantity;

    public CartItem() {
        product = null;
        quantity = 0;
    }

    public static CartItem getInstance() {
        return new CartItem();
    }

    @Override
    public Integer getPrice() {
        return product == null ? 0 : product.getPrice() * quantity;
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
    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equivalent(CartItemCalibratable comparator) {
        String comparatorProductId = comparator.getProduct() == null ? null : comparator.getProduct().getId();
        String thisProductId = this.getProduct().getId();
        if (thisProductId.equals(comparatorProductId)) {
            return true;
        }
        boolean isEquivalent = comparator.getProduct() == null || this.getProduct().equivalent(comparator.getProduct());
        isEquivalent &= comparator.getQuantity() == null || this.getQuantity().equals(comparator.getQuantity());
        return isEquivalent;
    }
}
