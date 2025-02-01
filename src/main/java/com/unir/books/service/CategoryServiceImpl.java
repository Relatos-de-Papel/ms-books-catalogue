package com.unir.books.service;

import com.unir.books.controller.model.CreateCategoryRequest;
import com.unir.books.data.CategoryRepository;
import com.unir.books.data.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category createCategory(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CreateCategoryRequest request) {
        Category category = categoryRepository.getById(id);
        if (category != null) {
            category.setName(request.getName());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.getById(id);
        if (category != null) {
            categoryRepository.delete(category);
        }
    }
}