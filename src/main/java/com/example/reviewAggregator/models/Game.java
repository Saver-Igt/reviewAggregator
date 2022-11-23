package com.example.reviewAggregator.models;

import javax.persistence.*;

@Entity
@Table(name="games")
public class Game {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "avg_rate")
    private float avgRate;
    @Column(name = "icon_url")
    private String iconURL;

    public Game(){}
    public Game(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getIconURL() {
        return iconURL;
    }
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
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
