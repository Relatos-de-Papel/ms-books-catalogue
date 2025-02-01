package com.unir.books.data;

import com.unir.books.data.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EditorialJpaRepository extends JpaRepository<Editorial, Long>, JpaSpecificationExecutor<Editorial> {
    List<Editorial> findByName(String name);
}