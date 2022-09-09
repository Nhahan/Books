package com.example.books.service;

import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = this.bookRepository.findAll();
        if (books.isEmpty()) {
            throw new ResourceNotFoundException("Books not found");
        }
        return books;
    }
}
