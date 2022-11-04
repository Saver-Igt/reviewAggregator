package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews() throws Exception;

    Review getReview(int id) throws Exception;

    Review addReview(Review review) throws Exception;

    Review editReview(int id,int grade,String comment,int idUser,int idProduct) throws Exception;

    void deleteReview(int id) throws Exception;
}
