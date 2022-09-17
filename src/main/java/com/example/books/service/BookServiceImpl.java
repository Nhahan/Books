package com.example.books.service;

import com.example.books.dto.AuthorResponseDto;
import com.example.books.dto.BookRequestDto;
import com.example.books.dto.BookResponseDto;
import com.example.books.model.Author;
import com.example.books.model.AuthorBook;
import com.example.books.model.Book;
import com.example.books.repository.AuthorBookRepository;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public Long createBook(BookRequestDto bookRequestDto) {
        Book book = bookRepository.save(new Book(bookRequestDto));

        List<Author> authors = bookRequestDto.getAuthorIds().stream()
                .map(authorId -> authorRepository.findById(authorId).orElseThrow(NoSuchElementException::new))
                .collect(Collectors.toList());

        authors.forEach(author -> authorBookRepository.save(new AuthorBook(author, book)));

        return book.getId();
    }

    @Override
    public List<BookResponseDto> getBooks(Pageable pageable) {
        List<Book> books = this.bookRepository.findAllBy(pageable);
        if (books.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> bookIds = books.stream().map(Book::getId).collect(Collectors.toList());
        Map<Long, List<AuthorResponseDto>> authorBooks = authorBookRepository.findAllByBookIds(bookIds).stream()
                .collect(Collectors.groupingBy(
                        authorBook -> authorBook.getBook().getId(),
                        Collectors.mapping(authorBook -> new AuthorResponseDto(authorBook.getAuthor()),
                                Collectors.toList())));

        return books.stream()
                .map(book -> new BookResponseDto(book, authorBooks.get(book.getId())))
                .collect(Collectors.toList());
    }
}
