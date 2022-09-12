package com.example.books.service;

import com.example.books.dto.AuthorRequestDto;
import com.example.books.dto.AuthorResponseDto;

public interface AuthorService {
    Long createAuthor(AuthorRequestDto authorRequestDto);
    AuthorResponseDto getAuthorById(long authorId);
}
