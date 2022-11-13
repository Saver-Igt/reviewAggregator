package com.example.reviewAggregator.models;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column(name = "avg_rate")
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
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getAvgRate() {
        return avgRate;
    }
    public void setAvgRate(float avgRate) {
        this.avgRate = avgRate;
    }
}
