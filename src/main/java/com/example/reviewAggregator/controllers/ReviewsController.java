package com.example.reviewAggregator.controllers;

import com.example.reviewAggregator.models.Review;
import com.example.reviewAggregator.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private final ReviewService reviewService;
    public ReviewsController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @GetMapping
    public @ResponseBody
    List<Review> getReviews() throws Exception{
        return reviewService.getReviews();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Review getReview(@PathVariable int id) throws Exception{
        return reviewService.getReview(id);
    }
    @PostMapping
    public @ResponseBody
    Review addReview(@RequestBody Review review) throws Exception{
        return reviewService.addReview(review);
    }
    @PutMapping("/{id}")
    public@ResponseBody
    Review editReview(@PathVariable int id,
                      @RequestBody int grade,
                      @RequestBody String comment,
                      @RequestBody int idUser,
                      @RequestBody int idProduct) throws Exception{
        return reviewService.editReview(id, grade, comment, idUser,idProduct);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable int id)throws Exception{
        reviewService.deleteReview(id);
    }
}
