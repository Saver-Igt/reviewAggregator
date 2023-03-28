package dev.siraev.services;

import dev.siraev.models.Game;
import dev.siraev.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews() throws Exception;

    Review getReview(Long userId, Long gameId) throws Exception;

    List<Review> getReviewsByGameId(Long gameId) throws Exception;
    List<Review> getReviewsByUserId(Long userId) throws Exception;
    Review addReview(Review review) throws Exception;
    Review editReview(Long userId, Long gameId, Review review) throws Exception;
    void deleteReview(Long userId, Long gameId) throws Exception;

}
