package com.unir.books.service;

import java.util.List;

import com.unir.books.data.model.Review;

public interface ReviewService {
    
    
    Review createReview(Review review);
    Review getReviewById(Long id);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
    List<Review> getBookReviews(Long bookId);
    

}
