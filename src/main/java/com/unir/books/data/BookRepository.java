package com.unir.books.data;

import com.unir.books.data.model.Book;
import com.unir.books.data.model.Product;
import com.unir.books.data.utils.Consts;
import com.unir.books.data.utils.SearchCriteria;
import com.unir.books.data.utils.SearchOperation;
import com.unir.books.data.utils.SearchStatement;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final BookJpaRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void delete(Book book) {
        repository.delete(book);
    }

    public List<Book> search(String name, String author, String category, String ISBN) {
        SearchCriteria<Book> spec = new SearchCriteria<>();

        if (StringUtils.isNotBlank(name)) {
            spec.add(new SearchStatement("name", name, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(author)) {
            spec.add(new SearchStatement("autor.name", author, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(category)) {
            spec.add(new SearchStatement("category", category, SearchOperation.EQUAL));
        }

        if (ISBN != null) {
            spec.add(new SearchStatement("isbn", ISBN, SearchOperation.EQUAL));
        }

        return repository.findAll(spec);
    }

}
