package com.unir.books.service;



import com.unir.books.controller.model.BookDto;
import com.unir.books.controller.model.CreateBookRequest;
import com.unir.books.data.model.Book;

import java.util.List;


public interface BooksService {

    List<Book> getBooks(String name, String author, String category, String ISBN);

    Book getBook(String bookId);

    Boolean removeBook(String bookId);

    Book createBook(CreateBookRequest request);

    Book updateBook(String bookId, String updateRequest);

    Book updateBook(String bookId, BookDto updateRequest);
}
