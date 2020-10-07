package com.thewithel.recipeproject.services;

import com.thewithel.recipeproject.commands.RecipeCommand;
import com.thewithel.recipeproject.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long idToDelete);
}
