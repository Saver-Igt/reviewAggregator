package dev.siraev.services;

import dev.siraev.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews() throws Exception;

    Review getReview(Long userId, Long gameId) throws Exception;

    Review addReview(Review review) throws Exception;

}
