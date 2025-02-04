package com.unir.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unir.books.data.ReviewRepository;
import com.unir.books.data.model.Review;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.getById(id);
    }

    public Review updateReview(Long id, Review review) {

        Review reviewToUpdate = reviewRepository.getById(id);

        if (reviewToUpdate != null) {
            reviewToUpdate.setRank(review.getRank());
            reviewToUpdate.setReview(review.getReview());

            return reviewRepository.save(review);
        }
        return null;
    }

    public void deleteReview(Long id) {
        Review reviewToDelete = reviewRepository.getById(id);
            reviewRepository.delete(reviewToDelete);
 
    }

    public List<Review> getBookReviews(Long bookId) {
        return reviewRepository.getBookReviews(bookId);
    }
}
