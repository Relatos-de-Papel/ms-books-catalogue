package com.unir.books.service;

import com.unir.books.controller.model.CreateEditorialRequest;
import com.unir.books.data.model.Editorial;

import java.util.List;

public interface EditorialService {
    List<Editorial> getEditorials();
    Editorial getEditorialById(Long id);
    Editorial createEditorial(CreateEditorialRequest request);
    Editorial updateEditorial(Long id, CreateEditorialRequest request);
    void deleteEditorial(Long id);
}