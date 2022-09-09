package com.example.books.service;

import com.example.books.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book createBook(Book book);
    Page<Book> getBooks(int page, int size);
}
