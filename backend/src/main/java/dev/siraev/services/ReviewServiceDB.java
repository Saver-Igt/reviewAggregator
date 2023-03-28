package dev.siraev.services;

import dev.siraev.models.Game;
import dev.siraev.models.Review;
import dev.siraev.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceDB implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final GameService gameService;
    public ReviewServiceDB(ReviewRepository reviewRepository, GameService gameService) {
        this.gameService = gameService;
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
        Review result = reviewRepository.save(review);
        changeGameAvgRating(review.getGameId());
        return result;
    }

    @Override
    public List<Review> getReviewsByUserId(Long userId) throws Exception {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public Review editReview(Long userId, Long gameId, Review review) throws Exception {
        Review findReview = getReview(userId, gameId);
        findReview.setScore(review.getScore());
        findReview.setComment(review.getComment());
        Review result = reviewRepository.save(findReview);
        changeGameAvgRating(gameId);
        return result;
    }

    @Override
    public void deleteReview(Long userId, Long gameId) throws Exception {
        Review findReview = getReview(userId, gameId);
        reviewRepository.delete(findReview);
        changeGameAvgRating(gameId);
    }
    public void changeGameAvgRating(Long gameId) throws Exception {
        List<Review> reviews = getReviewsByGameId(gameId);

        Long countReview = reviews.stream().count();

        int sum = 0;
        for (Review review: reviews) {
            sum += review.getScore();
        }

        int result = Math.round(sum/countReview);

        gameService.changeAvgRating(gameId, result);

    }
}
