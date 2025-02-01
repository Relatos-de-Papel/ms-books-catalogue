package com.unir.books.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unir.books.controller.model.BookDto;
import com.unir.books.controller.model.CreateBookRequest;
import com.unir.books.data.AuthorRepository;
import com.unir.books.data.BookRepository;
import com.unir.books.data.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
@Slf4j

public class BookServiceImp implements  BooksService{


    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EditorialService editorialService;



    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Book> getBooks(String name, String author, String category, String ISBN) {
        if (StringUtils.hasLength(name) || StringUtils.hasLength(author) || StringUtils.hasLength(category) || StringUtils.hasLength(ISBN)) {
            return repository.search(name, author, category, ISBN);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }

    @Override
    public Book getBook(String bookId) {
       return repository.getById(Long.valueOf(bookId));
    }

    @Override
    public Boolean removeBook(String bookId) {

        var book=  repository.getById(Long.valueOf(bookId));

        if (book == null) {
            return false;
        }

        //todo: add status enum for book
        book.setStatus("DELETED");
        repository.save(book);

        return true;
    }

    @Override
    public Book createBook(CreateBookRequest request) {

        var author = authorService.getAuthorById(request.getAuthorId());
        var category = categoryService.getCategoryById(request.getCategoryId());
        var editorial = editorialService.getEditorialById(request.getEditorialId());

        Book book = Book.builder()
                .name(request.getName())
                .author(author)
                .category(category)
                .editorial(editorial)
                .ISBN(request.getISBN())
                .build();

        return repository.save(book);

    }

    @Override
    public Book updateBook(String bookId, String updateRequest) {
        return null;
    }

    @Override
    public Book updateBook(String bookId, BookDto updateRequest) {
        return null;
    }
}
