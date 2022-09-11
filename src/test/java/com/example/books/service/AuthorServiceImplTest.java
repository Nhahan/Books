package com.example.books.service;

import com.example.books.model.Author;
import com.example.books.repository.AuthorBookRepository;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorServiceImplTest {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImplTest(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Test
    void createAuthor() {
        Author author = new Author("test", LocalDate.of(2020, 1, 8));
        authorRepository.save(author);

        assertThat(authorRepository.findById(author.getId())).isNotNull();
    }
}