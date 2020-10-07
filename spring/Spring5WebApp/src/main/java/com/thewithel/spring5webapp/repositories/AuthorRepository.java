package com.thewithel.spring5webapp.repositories;

import com.thewithel.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

// as a parameter it takes Generic type, and an id type
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
