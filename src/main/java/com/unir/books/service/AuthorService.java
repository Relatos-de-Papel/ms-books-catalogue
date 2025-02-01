package com.unir.books.service;

import com.unir.books.controller.model.CreateAuthorRequest;
import com.unir.books.data.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    Author getAuthorById(Long id);
    Author createAuthor(CreateAuthorRequest request);
    Author updateAuthor(Long id, CreateAuthorRequest request);
    void deleteAuthor(Long id);
}