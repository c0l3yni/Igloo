package com.tekgs.nextgen.igloo.view.cart.item.product;

import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;

public class ProductRegionExpected implements ProductRegionCalibratable {
    private final ProductCalibratable product;

    private ProductRegionExpected(ProductCalibratable product) {
        this.product = product;
    }

    public static ProductRegionExpected getInstance(ProductCalibratable product) {
        return new ProductRegionExpected(product);
    }

    @Override
    public ProductCalibratable getProduct() {
        return product;
    }

    @Override
    public String getPrice() {
        return String.format("$%.2f", (float) product.getPrice() / 100);
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
}
