package com.unir.books.service;

import com.unir.books.data.model.Category;
import com.unir.books.controller.model.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long id);
    Category createCategory(CreateCategoryRequest request);
    Category updateCategory(Long id, CreateCategoryRequest request);
    void deleteCategory(Long id);
}