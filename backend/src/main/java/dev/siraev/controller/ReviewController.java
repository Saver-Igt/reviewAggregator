package dev.siraev.controller;

import dev.siraev.models.Review;
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
    public @ResponseBody List<Review> getReviews() throws Exception{
        return reviewService.getReviews();
    }
    @GetMapping("/u{userId}/g{gameId}")
    public @ResponseBody Review getReview(@PathVariable Long userId, @PathVariable Long gameId) throws Exception{
        return reviewService.getReview(userId,gameId);
    }
}
