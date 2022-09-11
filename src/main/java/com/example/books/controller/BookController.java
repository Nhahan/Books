package com.example.books.controller;

import com.example.books.dto.BookRequestDto;
import com.example.books.dto.BookResponseDto;
import com.example.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDto>> getBooks(@RequestParam int page, @RequestParam(required = false , defaultValue = "10") int size) {
        return ResponseEntity.ok().body(this.bookService.getBooks(page, size));
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.ok().body(this.bookService.createBook(bookRequestDto));
    }
}
