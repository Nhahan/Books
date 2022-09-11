package com.example.books.service;

import com.example.books.dto.BookRequestDto;
import com.example.books.dto.BookResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookResponseDto createBook(BookRequestDto bookRequestDto);
    List<BookResponseDto> getBooks(Pageable pageable);
}
