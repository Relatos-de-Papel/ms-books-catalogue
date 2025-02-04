package com.unir.books.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unir.books.data.model.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {
    private final ReviewJpaRepository repository;

    public List<Review> getBookReviews(Long bookId) {
        return repository.findByBookId(bookId);
    }

    public Review save(Review review) {
        return repository.save(review);
    }

    public void delete(Review review) {
        repository.delete(review);
    }

    public Review getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public Review update(Review review) {
        return repository.save(review);
    }


}
