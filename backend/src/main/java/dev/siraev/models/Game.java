package dev.siraev.models;

import com.fasterxml.jackson.annotation.JsonView;
import dev.siraev.repository.ReviewRepository;
import dev.siraev.services.ReviewService;
import dev.siraev.services.ReviewServiceDB;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="games")
public class Game {
    @Id
    private Long id;
    @Column(name = "name")
    @JsonView(Views.Review.class)
    private String name;
    @Column(name = "description")
    @JsonView(Views.Review.class)
    private String description;
    @Column(name = "avg_rate")
    @JsonView(Views.Review.class)
    private int avgRate;
    @Column(name = "icon_url")
    @JsonView(Views.Review.class)
    private String iconURL;
    @Column(name = "steam_appid")
    private Long steam_appid;

    public Game(){}
    public Game(Long id, String name, String description, int avgRate, String iconURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avgRate = avgRate;
        this.iconURL = iconURL;
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
    public int getAvgRate() {
        return avgRate;
    }
    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }
    public String getIconURL() {
        return iconURL;
    }
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
    public Long getSteam_appid() {
        return steam_appid;
    }
    public void setSteam_appid(Long steam_appid) {
        this.steam_appid = steam_appid;
    }
}
