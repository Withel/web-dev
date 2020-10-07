package com.thewithel.recipeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Way of writing this app
// 1. Make Tests, mimic the behaviour you want to get
// 2. Write Controllers
// 3. Write Services

@SpringBootApplication
public class RecipeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeProjectApplication.class, args);
    }

}
