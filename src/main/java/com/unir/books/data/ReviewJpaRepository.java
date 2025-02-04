
package com.unir.books.data;

import com.unir.books.data.model.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

    List<Review> findByBookId(Long bookId);

}
