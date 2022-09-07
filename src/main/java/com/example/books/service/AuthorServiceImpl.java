package com.example.books.service;

import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.Author;
import com.example.books.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long authorId) {
        Optional<Author> optionalAuthor = this.authorRepository.findById(authorId);

        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            throw new ResourceNotFoundException("Author not found with id: " + authorId);
        }
    }

    @Override
    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }
}
