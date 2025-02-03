package com.unir.books.controller.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BookDto {
    private String name;
    private Long authorId;
    private Long categoryId;
    private Long editorialId;
    private Long unitPrice;
    private String ISBN;
    private Long stock;
    private Date datePublished;
    private String type;
    private boolean visible;
}
