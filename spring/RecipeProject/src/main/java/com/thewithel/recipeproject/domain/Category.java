package com.thewithel.recipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
// we need to exclude recipes because Project Lombok will enter the infinite
// loop because of bidirectional relationship
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
