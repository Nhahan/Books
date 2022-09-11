package com.example.books.service;

import com.example.books.model.Author;
import com.example.books.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
        Optional<Author> optionalAuthor = this.authorRepository.findById(authorId);

        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            throw new NullPointerException("Author not found with id: " + authorId);
        }
    }
}
