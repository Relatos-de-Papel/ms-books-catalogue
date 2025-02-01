package com.unir.books.data;

import com.unir.books.data.model.Editorial;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EditorialRepository {
    private final EditorialJpaRepository repository;

    public List<Editorial> getEditorials() {
        return repository.findAll();
    }

    public Editorial getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Editorial save(Editorial editorial) {
        return repository.save(editorial);
    }

    public void delete(Editorial editorial) {
        repository.delete(editorial);
    }

    public List<Editorial> findByName(String name) {
        return repository.findByName(name);
    }
}