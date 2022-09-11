package com.example.books.service;

import com.example.books.model.Author;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(long authorId);
}
