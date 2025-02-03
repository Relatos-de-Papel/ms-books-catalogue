package com.unir.books.data.utils;


import com.unir.books.controller.model.BookDto;
import com.unir.books.data.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mappings({
            @Mapping(source = "author.id", target = "authorId"),
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "editorial.id", target = "editorialId"),
            @Mapping(source = "ISBN", target = "ISBN"),
            @Mapping(source = "stock", target = "stock")
    })
    BookDto bookToBookDto(Book book);

    @Mappings({
            @Mapping(source = "authorId", target = "author.id"),
            @Mapping(source = "categoryId", target = "category.id"),
            @Mapping(source = "editorialId", target = "editorial.id"),
            @Mapping(source = "ISBN", target = "ISBN")
    })
    Book bookDtoToBook(BookDto bookDto);

}
