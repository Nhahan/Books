package com.example.books.service;

import com.example.books.dto.BookRequestDto;
import com.example.books.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    List<BookResponseDto> getBooks(int page, int size);
}
