package com.unir.books.data;

import com.unir.books.data.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final CategoryJpaRepository repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

    public List<Category> findByName(String name) {
        return repository.findByName(name);
    }
}