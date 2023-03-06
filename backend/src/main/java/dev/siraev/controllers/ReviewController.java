package dev.siraev.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.siraev.models.Review;
import dev.siraev.models.Views;
import dev.siraev.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @JsonView(Views.Review.class)
    public @ResponseBody List<Review> getReviews() throws Exception{
        return reviewService.getReviews();
    }
    @GetMapping("/u{userId}/g{gameId}")
    public @ResponseBody Review getReview(@PathVariable Long userId, @PathVariable Long gameId) throws Exception{
        return reviewService.getReview(userId,gameId);
    }
    @GetMapping("/g{gameId}")
    @JsonView(Views.Review.class)
    public @ResponseBody List<Review> getReviewsByGame(@PathVariable Long gameId)throws Exception{
        return reviewService.getReviewsByGameId(gameId);
    }
}
