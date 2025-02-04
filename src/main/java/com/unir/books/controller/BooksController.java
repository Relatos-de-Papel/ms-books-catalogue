package com.unir.books.controller;


import com.unir.books.controller.model.BookDto;
import com.unir.books.controller.model.CreateBookRequest;
import com.unir.books.data.model.Book;
import com.unir.books.data.model.Review;
import com.unir.books.service.BooksService;
import com.unir.books.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "books Controller", description = "Microservicio encargado de exponer operaciones CRUD los libros")
public class BooksController {

    private final BooksService bookService;
    private final ReviewService reviewService;

    @GetMapping("/books")
    @Operation(
            operationId = "getBooks",
            description = "Obtiene una lista de libros dependiendo los parametros de busqueda",
            summary = "Get all books")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No books found")
    public ResponseEntity<List<Book>> getBooks(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) Date datePublished,
            @RequestParam(required = false) Integer ranking

    ) {
        List<Book> books = bookService.getBooks( title, author, category, isbn,datePublished,ranking);

        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/books/{bookId}")
    @Operation(
            operationId = "getBookById",
            description = "Obtiene un libro por su ID",
            summary = "Get book by ID")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Book not found")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId) {
        Book book = bookService.getBook(bookId);

        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books")
    @Operation(
            operationId = "createBook",
            description = "Crea un nuevo libro",
            summary = "Create a new book")
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Invalid input")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest book) {
        Book createdBook = bookService.createBook(book);
        if (createdBook != null) {
            return ResponseEntity.status(201).body(createdBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/books/{bookId}")
    @Operation(
        operationId = "updateBook",
        description = "Actualiza un libro existente",
        summary = "Update an existing book")
    @ApiResponse(
        responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponse(
        responseCode = "404",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Book not found")
    @ApiResponse(
        responseCode = "400",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Invalid input")
    public ResponseEntity<Book> updateBook(
        @PathVariable("bookId") Long bookId,
        @RequestBody BookDto book) {
        Book updatedBook = bookService.updateBook(bookId, book);
        if (updatedBook != null) {
        return ResponseEntity.ok(updatedBook);
        } else {
        return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/books/{bookId}")
    @Operation(
        operationId = "patchBook",
        description = "Actualiza parcialmente un libro existente",
        summary = "Patch an existing book")
    @ApiResponse(
        responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponse(
        responseCode = "404",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Book not found")
    @ApiResponse(
        responseCode = "400",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Invalid input")
    public ResponseEntity<Book> patchBook(
        @PathVariable("bookId") Long bookId,
        @RequestBody  String patchBody) {
        Book patchedBook = bookService.updateBook(bookId, patchBody);
        if (patchedBook != null) {
            return ResponseEntity.ok(patchedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/{bookId}/reviews")
    @Operation(
        operationId = "getBookReviews",
        description = "Obtiene las reseñas de un libro por su ID",
        summary = "Get book reviews by ID")
    @ApiResponse(
        responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class)))
    @ApiResponse(
        responseCode = "404",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Book not found")
    public ResponseEntity<List<Review>> getBookReviews(@PathVariable("bookId") Long bookId) {

        List<Review> reviews = reviewService.getBookReviews(bookId);

        if (reviews != null && !reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @PostMapping("/books/{bookId}/reviews")
    @Operation(
        operationId = "createReview",
        description = "Crea una nueva reseña para un libro",
        summary = "Create a new review for a book")
    @ApiResponse(
        responseCode = "201",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Review.class)))
    @ApiResponse(
        responseCode = "400",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
        description = "Invalid input")
    public ResponseEntity<Review> createReview(
        @PathVariable("bookId") Long bookId,
        @RequestBody Review review) {
        
        var book = bookService.getBook(bookId);
        review.setBook(book);
        Review createdReview = reviewService.createReview(review);
        if (createdReview != null) {
            return ResponseEntity.status(201).body(createdReview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}



