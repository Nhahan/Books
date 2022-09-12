package com.example.books.controller;

import com.example.books.dto.AuthorRequestDto;
import com.example.books.dto.AuthorResponseDto;
import com.example.books.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.authorService.getAuthorById(id));
    }

    @PostMapping("/authors")
    public ResponseEntity<Long> createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return ResponseEntity.ok().body(this.authorService.createAuthor(authorRequestDto));
    }
}
