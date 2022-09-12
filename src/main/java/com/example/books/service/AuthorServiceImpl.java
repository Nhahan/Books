package com.example.books.service;

import com.example.books.dto.AuthorRequestDto;
import com.example.books.dto.AuthorResponseDto;
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
    public Long createAuthor(AuthorRequestDto authorRequestDto) {
        return authorRepository.save(new Author(authorRequestDto)).getId();
    }

    @Override
    public AuthorResponseDto getAuthorById(long authorId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new NullPointerException("Author not found, id: " + authorId));
        return new AuthorResponseDto(author);
    }
}
