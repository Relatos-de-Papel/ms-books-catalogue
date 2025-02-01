package com.unir.books.data;

import com.unir.books.data.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final AuthorJpaRepository repository;


    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public void delete(Author author) {
        repository.delete(author);
    }

}
