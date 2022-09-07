package com.example.books.service;

import com.example.books.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getBooks();
}
