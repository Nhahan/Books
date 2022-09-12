package com.example.books.model;

import com.example.books.constant.Currency;
import com.example.books.dto.BookRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column @NotBlank @Size(min=1, max=255)
    private String title;
    @Column @NotNull
    private Boolean discontinued;
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    @Column @NotBlank
    private String isbn;
    @Column @NotNull
    private int pages;
    @Column
    private LocalDate yearOfPublication;
    @Column @Digits(integer = 12, fraction = 2)
    private Double price;
    @Column
    private Currency currency;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Book(BookRequestDto bookRequestDto) {
        this.title = bookRequestDto.getTitle();
        this.discontinued = bookRequestDto.getDiscontinued();
        this.isbn = bookRequestDto.getIsbn();
        this.pages = bookRequestDto.getPages();
        this.yearOfPublication = bookRequestDto.getYearOfPublication();
        this.price = bookRequestDto.getPrice();
        this.currency = bookRequestDto.getCurrency();
    }

    @AssertTrue(message = "If price exist, so should the currency. If not, there should be no currency.")
    private boolean isCurrencyValid() {
        if (price != null && currency == null) {
            return false;
        }
        if (price == null && currency != null) {
            return false;
        }
        return true;
    }
}
