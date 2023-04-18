package com.tekgs.nextgen.igloo.data.product;

import com.google.gson.Gson;

public class ProductDefinition implements ProductCalibratable {
    private Integer price;
    private String description;
    @SuppressWarnings("unused")
    private String id;

    public static ProductDefinition getInstance() {
        return new ProductDefinition();
    }

    @Override
    public Integer getPrice() {
        return price;
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
        if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean isEquivalent = comparator.getDescription() == null || this.getDescription().equals(comparator.getDescription());
        isEquivalent &= comparator.getPrice() == null || this.getPrice().equals(comparator.getPrice());
        return isEquivalent;
    }

    @Override
    public String getId() {
        return id;
    }

    public ProductDefinition withPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }

    public ProductDefinition withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductDefinition withId(String id) {
        this.id = id;
        return this;
    }
}
