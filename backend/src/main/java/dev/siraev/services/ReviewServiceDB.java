package dev.siraev.services;

import dev.siraev.models.Review;
import dev.siraev.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceDB implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceDB(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public List<Review> getReviews() throws Exception {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long userId, Long gameId) throws Exception {
        return reviewRepository.findByUserIdAndGameId(userId, gameId);
    }

    @Override
    public List<Review> getReviewsByGameId(Long gameId) throws Exception {
        return reviewRepository.findByGameId(gameId);
    }

    @Override
    public Review addReview(Review review) throws Exception {
        return null;
    }
}
