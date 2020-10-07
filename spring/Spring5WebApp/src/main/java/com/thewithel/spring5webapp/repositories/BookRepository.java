package com.thewithel.spring5webapp.repositories;

import com.thewithel.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
