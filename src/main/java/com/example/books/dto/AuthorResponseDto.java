package com.example.books.dto;

import com.example.books.model.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
public class AuthorResponseDto {
    private Long id;
    private String name;
    private LocalDate birth;
    private Date createAt;
    private Date updatedAt;

    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.birth = author.getBirth();
        this.createAt = author.getCreateAt();
        this.updatedAt = author.getUpdatedAt();
    }
}
