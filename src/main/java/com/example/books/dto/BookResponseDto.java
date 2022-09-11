package com.example.books.dto;

import com.example.books.constant.Currency;
import com.example.books.model.Author;
import com.example.books.model.Book;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class BookResponseDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String title;
    private Boolean discontinued;
    private String isbn;
    private int pages;
    private LocalDate yearOfPublication;
    private Double price;
    private Currency currency;
    private List<Author> authors;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date createAt;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date updatedAt;

    public BookResponseDto(Book book, List<Author> authors) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.discontinued = book.getDiscontinued();
        this.isbn = book.getIsbn();
        this.pages = book.getPages();
        this.yearOfPublication = book.getYearOfPublication();
        this.price = book.getPrice();
        this.currency = book.getCurrency();
        this.authors = authors;
        this.createAt = book.getCreateAt();
        this.updatedAt = book.getUpdatedAt();
    }
}
