package com.tekgs.nextgen.igloo.data.product;

public interface ProductCalibratable {
    Integer getPrice();

    String getDescription();

    boolean equivalent(ProductCalibratable comparator);

    String getId();
}
