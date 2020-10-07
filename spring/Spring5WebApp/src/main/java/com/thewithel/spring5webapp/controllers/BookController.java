package com.thewithel.spring5webapp.controllers;

import com.thewithel.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    // we need to add an constructor because when spring will create
    // this class it will automatically inject the instance of the book repository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // this will get invoked whenever /books request will come
    // to our web app
    @RequestMapping("/books")
    public String getBooks(Model model){

        // were taking a model that gets passed in and were gonna add
        // an attribute called books so its gonna be the list books from bookRepository
        // this is gonna tell spring data JPA to go out and get the list of books
        // from the database and Spring MVC is gonna asociate that list to model

        // its returning iterable so we can iterate it through thymeleaf
        model.addAttribute("books", bookRepository.findAll());

        // this is gonna asociate it with thymeleaf view
        return "books";
    }
}
