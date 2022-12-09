package com.tworuszka.spring5webapp.controllers;

import com.tworuszka.spring5webapp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
