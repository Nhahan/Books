package com.example.books.service;

import com.example.books.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(long authorId);
    List<Author> getAuthors();
}
