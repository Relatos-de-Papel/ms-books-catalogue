package com.unir.books.data;

import com.unir.books.data.model.Author;
import com.unir.books.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

interface BookJpaRepository  extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    List<Book> findByName(String name);

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByCategory_Name(String categoryName);

    List<Book> findByISBN(String ISBN);


}
