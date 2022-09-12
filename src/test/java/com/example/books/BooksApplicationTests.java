package com.example.books;

import com.example.books.dto.AuthorRequestDto;
import com.example.books.dto.BookRequestDto;
import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.repository.AuthorBookRepository;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.books.constant.Currency.KRW;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BooksApplicationTests {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorBookRepository authorBookRepository;

    @Autowired
    BooksApplicationTests(BookRepository bookRepository, AuthorRepository authorRepository, AuthorBookRepository authorBookRepository) {
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
    void create() {
        AuthorRequestDto authorRequestDto = new AuthorRequestDto("test", LocalDate.of(2020, 1, 8));
        Author author = authorRepository.save(new Author(authorRequestDto));

        BookRequestDto bookRequestDto = new BookRequestDto(
                "title",
                false,
                "ISBN 978-0-596-52068-7",
                3,
                LocalDate.of(2020, 1, 8),
                10.21,
                KRW,
                new ArrayList<>(List.of(1L)));
        Book book = bookRepository.save(new Book(bookRequestDto));

        assertThat(authorBookRepository.findById(author.getId())).isNotNull();
        assertThat(bookRepository.findById(book.getId())).isNotNull();
    }

}
