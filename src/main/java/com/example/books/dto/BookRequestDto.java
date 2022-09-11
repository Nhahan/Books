package com.example.books.dto;

import com.example.books.constant.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class BookRequestDto {
    private String title;
    private Boolean discontinued;
    private String isbn;
    private int pages;
    private LocalDate yearOfPublication;
    private Double price;
    private Currency currency;
    private List<Long> authorIds;

    public BookRequestDto(
            String title,
            Boolean discontinued,
            String isbn,
            int pages,
            LocalDate yearOfPublication,
            Double price,
            Currency currency,
            List<Long> authorIds) {
        this.title = title;
        this.discontinued = discontinued != null && discontinued;
        this.isbn = isbn;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.currency = currency;
        this.authorIds = authorIds;
    }
}
