package dev.siraev.models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name="reviews")
@IdClass(ReviewsKey.class)
public class Review {
    @Id
    @Column(name = "user_id")
    @JsonView(Views.Review.class)
    private Long userId;
    @Id
    @Column(name = "game_id")
    @JsonView(Views.Review.class)
    private Long gameId;
    @Column(name = "score")
    @JsonView(Views.Review.class)
    private String score;
    @Column(name = "comment")
    @JsonView(Views.Review.class)
    private String comment;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable = false, updatable = false)
    @JsonView(Views.Review.class)
    private User user;

    public Review(){}

    public Review(Long userId, Long gameId, String score, String comment, User user) {
        this.userId = userId;
        this.gameId = gameId;
        this.score = score;
        this.comment = comment;
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getGameId() {
        return gameId;
    }
    public String getValue() {
        return score;
    }
    public String getComment() {
        return comment;
    }

    public void setValue(String score) {
        this.score = score;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
