package com.unir.books.service;

import com.unir.books.controller.model.CreateAuthorRequest;
import com.unir.books.data.AuthorRepository;
import com.unir.books.data.model.Author;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private  AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getById(id);
    }

    @Override
    public Author createAuthor(CreateAuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, CreateAuthorRequest request) {
        Author author = authorRepository.getById(id);
        if (author != null) {
            author.setName(request.getName());
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.getById(id);
        if (author != null) {
            authorRepository.delete(author);
        }
    }
}