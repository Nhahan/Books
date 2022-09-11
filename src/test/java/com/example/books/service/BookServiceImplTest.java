package com.example.books.service;

import com.example.books.dto.BookRequestDto;
import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.repository.AuthorBookRepository;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookServiceImplTest {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorBookRepository authorBookRepository;

    @Autowired
    BookServiceImplTest(BookRepository bookRepository, AuthorRepository authorRepository, AuthorBookRepository authorBookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorBookRepository = authorBookRepository;
    }

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(bookRepository).isNotNull();
        assertThat(authorRepository).isNotNull();
        assertThat(authorBookRepository).isNotNull();
    }

    @Test
    void createBook() {
        authorRepository.save(new Author("test", LocalDate.of(2020, 1, 8)));

        BookRequestDto bookRequestDto = new BookRequestDto(
                "title",
                "ISBN 978-0-596-52068-7",
                3,
                LocalDate.of(2020, 1, 8),
                new ArrayList<Long>(List.of(1L)));
        Book savedBook = bookRepository.save(new Book(bookRequestDto));

        assertThat(bookRepository.findById(savedBook.getId())).isNotNull();
    }
}