package com.tekgs.nextgen.igloo.data.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public Product query(ProductDefinition productDefinition) {
        for (Product candidate : getProducts()) {
            if (candidate.equivalent(productDefinition)) {
                return candidate;
            }
        }
        return null;
    }

    private List<Product> getProducts() {
        List<Product> products = null;
        try (Reader productFile = new FileReader("../source/src/data/product.json")) {
            products = new Gson().fromJson(productFile, new TypeToken<ArrayList<Product>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products == null ? new ArrayList<>() : products;
    }
}
