package com.example.consumerorders.service;

import com.example.consumerorders.model.Product;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {

    public static Product getById(Integer id) {

        List<Product> products = new ArrayList<>();
        var product1 = new Product(1, "Coca Cola", "Refrigerentes", 7.98);
        var product2 = new Product(2, "Fanta", "Refrigerentes", 7.50);
        var product3 = new Product(3, "Guanará", "Refrigerentes", 6.59);
        var product4 = new Product(4, "Sukita", "Refrigerentes", 5.99);
        products.addAll(Arrays.asList(product1, product2, product3, product4));

        for (Product product: products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
