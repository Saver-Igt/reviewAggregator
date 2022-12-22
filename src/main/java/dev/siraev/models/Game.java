package dev.siraev.models;

import jakarta.persistence.*;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "avg_rate")
    private float avgRate;
    @Column(name = "icon_url")
    private String iconURL;
    public Game(){}
    public Game(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getIconURL() {
        return iconURL;
    }
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
