package com.tworuszka.spring5webapp.controllers;

import com.tworuszka.spring5webapp.model.Author;
import com.tworuszka.spring5webapp.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
//        return ResponseEntity.ok(authorRepository.findAll());
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

}
