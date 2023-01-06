package dev.siraev.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
@IdClass(ReviewsKey.class)
public class Review {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "game_id")
    private Long gameId;
    @Column(name = "scope")
    private String value;
    @Column(name = "comment")
    private String comment;

    public Review(){}
    public Review(Long userId, Long gameId, String value, String comment){
        this.userId = userId;
        this.gameId = gameId;
        this.value = value;
        this.comment = comment;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getGameId() {
        return gameId;
    }
    public String getValue() {
        return value;
    }
    public String getComment() {
        return comment;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
