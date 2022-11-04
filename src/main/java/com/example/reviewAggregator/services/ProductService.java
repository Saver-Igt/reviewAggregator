package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Product;
import com.example.reviewAggregator.models.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getProducts() throws Exception;

    Product getProduct(int id) throws Exception;

    Product addProduct(Product product) throws Exception;

    Product editProduct( int id, String name, String description, ProductType type) throws Exception;

    void deleteProduct(int id) throws Exception;
}
