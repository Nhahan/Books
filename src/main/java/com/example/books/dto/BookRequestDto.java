package com.example.books.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class BookRequestDto {
    private String title;
    private String isbn;
    private int pages;
    private LocalDate yearOfPublication;
    private List<Long> authorIds;
}
