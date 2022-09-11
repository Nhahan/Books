package com.example.books.service;

import com.example.books.model.Author;
import com.example.books.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long authorId) {
        return this.authorRepository.findById(authorId).orElseThrow(() -> new NullPointerException("Author not found, id: " + authorId));
    }
}
