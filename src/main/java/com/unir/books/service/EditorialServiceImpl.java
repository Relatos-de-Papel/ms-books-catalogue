package com.unir.books.service;

import com.unir.books.controller.model.CreateEditorialRequest;
import com.unir.books.data.EditorialRepository;
import com.unir.books.data.model.Editorial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private  EditorialRepository editorialRepository;

    @Override
    public List<Editorial> getEditorials() {
        return editorialRepository.getEditorials();
    }

    @Override
    public Editorial getEditorialById(Long id) {
        return editorialRepository.getById(id);
    }

    @Override
    public Editorial createEditorial(CreateEditorialRequest request) {
        Editorial editorial = new Editorial();
        editorial.setName(request.getName());
        return editorialRepository.save(editorial);
    }

    @Override
    public Editorial updateEditorial(Long id, CreateEditorialRequest request) {
        Editorial editorial = editorialRepository.getById(id);
        if (editorial != null) {
            editorial.setName(request.getName());
            return editorialRepository.save(editorial);
        }
        return null;
    }

    @Override
    public void deleteEditorial(Long id) {
        Editorial editorial = editorialRepository.getById(id);
        if (editorial != null) {
            editorialRepository.delete(editorial);
        }
    }
}