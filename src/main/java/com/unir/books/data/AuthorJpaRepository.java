package com.unir.books.data;

import com.unir.books.data.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AuthorJpaRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {

    List<Author> findByName(String name);
}