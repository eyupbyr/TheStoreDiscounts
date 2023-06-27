package com.eyupbyr;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> products;

    public Bill() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
