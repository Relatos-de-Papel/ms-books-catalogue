package com.unir.books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.books.controller.model.BookDto;
import com.unir.books.controller.model.CreateBookRequest;
import com.unir.books.data.BookRepository;
import com.unir.books.data.model.Book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
@Slf4j

public class BookServiceImp implements  BooksService{

    private final BookRepository repository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final EditorialService editorialService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BookServiceImp(BookRepository repository, AuthorService authorService, CategoryService categoryService, EditorialService editorialService, ObjectMapper objectMapper) {
        this.repository = repository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.editorialService = editorialService;
        this.objectMapper = objectMapper;
    }
    @Override
    public List<Book> getBooks(String name, String author, String category, String ISBN, Date datePublished,Integer ranking)
    {
        if (StringUtils.hasLength(name) ||
                StringUtils.hasLength(author) ||
                StringUtils.hasLength(category) ||
                StringUtils.hasLength(ISBN)) {
            return repository.search(name, author, category, ISBN, datePublished);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }

    @Override
    public Book getBook(Long bookId) {
       return repository.getById(bookId);
    }

    @Override
    public Boolean removeBook(String bookId) {

        var book=  repository.getById(Long.valueOf(bookId));

        if (book == null) {
            return false;
        }

        book.setVisible(false);
        book.setActive(false);

        repository.save(book);

        return true;
    }

    @Override
    public Book createBook(CreateBookRequest request) {

        var author = authorService.getAuthorById(request.getAuthorId());
        var category = categoryService.getCategoryById(request.getCategoryId());
        var editorial = editorialService.getEditorialById(request.getEditorialId());

        if (author == null || category == null || editorial == null) {
            return null;
        }

        Book book = Book.builder()
                .name(request.getName())
                .author(author)
                .category(category)
                .editorial(editorial)
                .ISBN(request.getIsbn())
                .stock(request.getStock())
                .unitPrice(request.getUnitPrice())
                .visible(true)
                .isActive(true)
                .datePublished(request.getDatePublished())
                .type(request.getType())
                .build();
        
     
        return repository.save(book);

    }

    @Override
    public Book updateBook(Long bookId, String request) {

        Book book = repository.getById(bookId);
        if (book != null) {
            try {
                JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
                JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(book)));
                Book patched = objectMapper.treeToValue(target, Book.class);
                repository.save(patched);
                return patched;
            } catch (JsonProcessingException | JsonPatchException e) {
                log.error("Error updating product {}", book, e);
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(Long bookId, BookDto updateRequest) {
        Book book = repository.getById(bookId);

               if (book != null) {
                var bookToSave = bookDtoToBook(book,updateRequest);
                   return repository.save(bookToSave);
               } else {
                   return null;
               }
           }
       
    private Book bookDtoToBook(Book book,BookDto updateRequest) {
               book.setName(updateRequest.getName());
                book.setAuthor(authorService.getAuthorById(updateRequest.getAuthorId()));
                book.setCategory(categoryService.getCategoryById(updateRequest.getCategoryId()));
                book.setEditorial(editorialService.getEditorialById(updateRequest.getEditorialId()));
                book.setISBN(updateRequest.getISBN());
                book.setStock(updateRequest.getStock());
                book.setUnitPrice(updateRequest.getUnitPrice());
                book.setDatePublished(updateRequest.getDatePublished());
                book.setType(updateRequest.getType());
                return book;
           }
       
           @Override
    public  void updateBookVisibility(String bookId, boolean visible) {

        var book  = repository.getById(Long.valueOf(bookId));
        book.setVisible(visible);
        repository.save(book);
    }

      

}
