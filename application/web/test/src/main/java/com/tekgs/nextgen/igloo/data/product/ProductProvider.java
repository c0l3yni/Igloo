package com.tekgs.nextgen.igloo.data.product;

public class ProductProvider {
    private final ProductRepository repository = ProductRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public Product get(ProductDefinition productDefinition) {
        return repository.query(productDefinition);
    }
}
