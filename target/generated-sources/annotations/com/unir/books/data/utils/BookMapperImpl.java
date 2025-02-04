package com.unir.books.data.utils;

import com.unir.books.controller.model.BookDto;
import com.unir.books.data.model.Author;
import com.unir.books.data.model.Author.AuthorBuilder;
import com.unir.books.data.model.Book;
import com.unir.books.data.model.Book.BookBuilder;
import com.unir.books.data.model.Category;
import com.unir.books.data.model.Category.CategoryBuilder;
import com.unir.books.data.model.Editorial;
import com.unir.books.data.model.Editorial.EditorialBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T11:24:02-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 23.0.1 (Homebrew)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setAuthorId( bookAuthorId( book ) );
        bookDto.setCategoryId( bookCategoryId( book ) );
        bookDto.setEditorialId( bookEditorialId( book ) );
        bookDto.setISBN( book.getISBN() );
        bookDto.setStock( book.getStock() );
        bookDto.setName( book.getName() );
        bookDto.setUnitPrice( book.getUnitPrice() );
        bookDto.setDatePublished( book.getDatePublished() );
        bookDto.setType( book.getType() );
        bookDto.setVisible( book.isVisible() );

        return bookDto;
    }

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        BookBuilder book = Book.builder();

        book.author( bookDtoToAuthor( bookDto ) );
        book.category( bookDtoToCategory( bookDto ) );
        book.editorial( bookDtoToEditorial( bookDto ) );
        book.ISBN( bookDto.getISBN() );
        book.name( bookDto.getName() );
        book.unitPrice( bookDto.getUnitPrice() );
        book.stock( bookDto.getStock() );
        book.datePublished( bookDto.getDatePublished() );
        book.type( bookDto.getType() );
        book.visible( bookDto.isVisible() );

        return book.build();
    }

    private Long bookAuthorId(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long bookCategoryId(Book book) {
        if ( book == null ) {
            return null;
        }
        Category category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long bookEditorialId(Book book) {
        if ( book == null ) {
            return null;
        }
        Editorial editorial = book.getEditorial();
        if ( editorial == null ) {
            return null;
        }
        Long id = editorial.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Author bookDtoToAuthor(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        AuthorBuilder author = Author.builder();

        author.id( bookDto.getAuthorId() );

        return author.build();
    }

    protected Category bookDtoToCategory(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.id( bookDto.getCategoryId() );

        return category.build();
    }

    protected Editorial bookDtoToEditorial(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        EditorialBuilder editorial = Editorial.builder();

        editorial.id( bookDto.getEditorialId() );

        return editorial.build();
    }
}
