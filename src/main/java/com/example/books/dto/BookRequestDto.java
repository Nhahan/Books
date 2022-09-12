package com.example.books.dto;

import com.example.books.constant.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class BookRequestDto {
    @Schema(description = "Required")
    private String title;
    @Schema(description = "default: false")
    private Boolean discontinued;
    @Schema(description = "Required / Example: ISBN 978-0-596-52068-7")
    private String isbn;
    @Schema(description = "Required")
    private int pages;
    @Schema(description = "Required")
    private LocalDate yearOfPublication;
    @Schema(description = "Up to 2 decimal places are possible")
    private Double price;
    @Schema(description = "Required if price exist")
    private Currency currency;
    @Schema(description = "Example: [1, 2]")
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
        this.discontinued = discontinued;
        this.isbn = isbn;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.currency = currency;
        this.authorIds = authorIds;
    }
}
