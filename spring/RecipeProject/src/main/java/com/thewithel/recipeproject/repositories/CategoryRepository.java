package com.thewithel.recipeproject.repositories;

import com.thewithel.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    // this is query method that is gonna find categories by description lmao
    Optional<Category> findByDescription(String description);
}
