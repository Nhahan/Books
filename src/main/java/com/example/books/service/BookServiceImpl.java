package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> getBooks(int page, int size) {
        Page<Book> books = this.bookRepository.findAll(PageRequest.of(page - 1, size));
        if (books.isEmpty()) {
            throw new NullPointerException("Books not found");
        }
        return books;
    }
}
