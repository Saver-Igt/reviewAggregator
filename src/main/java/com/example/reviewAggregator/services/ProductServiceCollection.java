package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Product;
import com.example.reviewAggregator.models.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceCollection implements ProductService{
    private List<Product> products = new ArrayList<>();
    public ProductServiceCollection() {
        products.add(new Product(1,"Star Wars: The Clone Wars", "Description", ProductType.SERIES));
        products.add(new Product(2,"Attack on Titan", "Description", ProductType.ANIME));
        products.add(new Product(3,"Queen - Bohemian Rhapsody", "Description", ProductType.MUSIC));
        products.add(new Product(4,"Cyberpunk", "Description", ProductType.GAME));
    }
    @Override
    public List<Product> getProducts() throws Exception {
        return products;
    }
    @Override
    public Product getProduct(int id) throws Exception {
        return products.stream().filter(product -> product.getId() == id).findFirst()
                .orElse(new Product());
    }
    @Override
    public Product addProduct(Product product) throws Exception {
        products.add(product);
        return product;
    }
    @Override
    public Product editProduct(int id, String name, String description, ProductType type) throws Exception {
        return products.stream().filter(product -> product.getId() == id).findFirst()
                .map(product -> {
                    product.setName(name);
                    product.setDescription(description);
                    product.setType(type);
                    return product;
                }).orElse(new Product());
    }
    @Override
    public void deleteProduct(int id) throws Exception {
        products = products.stream().filter(product -> product.getId() != id)
                .collect(Collectors.toList());
    }
}
