package dev.siraev.models;

import java.io.Serializable;

public class ReviewsKey implements Serializable {
    private Long userId;
    private Long gameId;

    public ReviewsKey(){}
    public ReviewsKey(Long userId, Long gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }
}
