package com.example.reviewAggregator.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private ProductType type;
    private float avgRate;

    public Product(){}
    public Product(int id, String name, String description, ProductType type){
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
