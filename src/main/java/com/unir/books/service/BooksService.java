package com.unir.books.service;



import com.unir.books.controller.model.BookDto;
import com.unir.books.controller.model.CreateBookRequest;
import com.unir.books.data.model.Book;

import java.util.Date;
import java.util.List;


public interface BooksService {

    List<Book> getBooks(String name, String author, String category, String ISBN, Date datePublished,Integer ranking);

    Book getBook(Long bookId);

    Boolean removeBook(String bookId);

    Book createBook(CreateBookRequest request);

    Book updateBook(Long bookId, String updateRequest);

    Book updateBook(Long bookId, BookDto updateRequest);

    void updateBookVisibility(String bookId, boolean visible);
}
