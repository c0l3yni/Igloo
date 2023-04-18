package com.tekgs.nextgen.igloo.data.product;

@SuppressWarnings("unused") //  Fields are populated by Gson
public class Product implements ProductCalibratable {
    private Integer price;
    private String description;
    private String id;

    private Product() {
    }

    @Override
    public Integer getPrice() {
        return price == null ? 0 : price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null) {
            return this.getId().equals(comparator.getId());
        }
        boolean isEquivalent = comparator.getPrice() == null || this.getPrice().equals(comparator.getPrice());
        isEquivalent &= comparator.getDescription() == null || this.getDescription().equals(comparator.getDescription());
        return isEquivalent;
    }

    @Override
    public String getId() {
        return id;
    }
}
