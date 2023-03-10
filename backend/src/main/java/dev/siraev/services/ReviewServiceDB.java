package dev.siraev.services;

import dev.siraev.models.Game;
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
        return reviewRepository.save(review);
    }

    @Override
    public Review editReview(Long userId, Long gameId, Review review) throws Exception {
        Review findReview = getReview(userId, gameId);
        findReview.setScore(review.getScore());
        findReview.setComment(review.getComment());
        return reviewRepository.save(findReview);
    }

    @Override
    public void deleteReview(Long userId, Long gameId) throws Exception {
        Review findReview = getReview(userId, gameId);
        reviewRepository.delete(findReview);
    }
}
