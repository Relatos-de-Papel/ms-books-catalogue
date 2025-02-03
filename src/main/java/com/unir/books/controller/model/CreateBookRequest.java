package com.unir.books.controller.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
        private String name;
        private Long authorId;
        private Long categoryId;
        private Long editorialId;
        private String isbn;
        private Long stock;
        private long unitPrice;
        private Date datePublished;
        private String type;
}



