package com.example.books.service;

import com.example.books.dto.BookRequestDto;
import com.example.books.dto.BookResponseDto;
import com.example.books.model.Author;
import com.example.books.model.AuthorBook;
import com.example.books.model.Book;
import com.example.books.repository.AuthorBookRepository;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorBookRepository authorBookRepository;

    @Override
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        Book savedBook = bookRepository.save(new Book(bookRequestDto));

        List<Author> authors = bookRequestDto.getAuthorIds().stream()
                .map(authorId -> authorRepository.findById(authorId).orElseThrow(NoSuchElementException::new))
                .collect(Collectors.toList());

        authors.forEach(author -> authorBookRepository.save(new AuthorBook(author, savedBook)));

        return new BookResponseDto(savedBook, authors);
    }

    @Override
    public List<BookResponseDto> getBooks(int page, int size) {
        List<Book> books = this.bookRepository.findAllBy(PageRequest.of(page - 1, size));
        if (books.isEmpty()) {
            throw new NoSuchElementException("Books not found");
        }
        return books.stream()
                .map(this::toBookResponseDto)
                .collect(Collectors.toList());
    }

    private BookResponseDto toBookResponseDto(Book book) {
        return new BookResponseDto(book, authorBookRepository.findAllByBookId(book.getId()).stream()
                .map(AuthorBook::getAuthor)
                .collect(Collectors.toList()));
    }
}
