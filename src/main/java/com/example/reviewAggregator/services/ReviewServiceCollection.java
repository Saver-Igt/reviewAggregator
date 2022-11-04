package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceCollection implements ReviewService{
    private List<Review> reviews = new ArrayList<>();
    public ReviewServiceCollection() {
        reviews.add(new Review(1,10,"Comment",1,1));
        reviews.add(new Review(2,7,"Comment",2,1));
        reviews.add(new Review(3,10,"Comment",3,1));
    }
    @Override
    public List<Review> getReviews() throws Exception {
        return reviews;
    }
    @Override
    public Review getReview(int id) throws Exception {
        return reviews.stream().filter(review -> review.getId() == id).findFirst()
                .orElse(new Review());
    }
    @Override
    public Review addReview(Review review) throws Exception {
        reviews.add(review);
        return review;
    }
    @Override
    public Review editReview(int id, int grade, String comment, int idUser, int idProduct) throws Exception {
        return reviews.stream().filter(review -> review.getId() == id).findFirst()
                .map(review -> {
                    review.setGrade(grade);
                    review.setComment(comment);
                    review.setIdUser(idUser);
                    review.setIdProduct(idProduct);
                    return review;
                }).orElse(new Review());
    }
    @Override
    public void deleteReview(int id) throws Exception {
        reviews = reviews.stream().filter(review -> review.getId() != id)
                .collect(Collectors.toList());
    }
}
