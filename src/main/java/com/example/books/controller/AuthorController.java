package com.example.books.controller;

import com.example.books.model.Author;
import com.example.books.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok().body(authorService.getAuthors());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable long id) {
        return ResponseEntity.ok().body(authorService.getAuthorById(id));
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok().body(this.authorService.createAuthor(author));
    }

    @DeleteMapping("/authors/{id}")
    public HttpStatus deleteAuthor(@PathVariable long id, @RequestBody Author author) {
        this.authorService.deleteAuthor(id);
        return HttpStatus.OK;
    }
}
