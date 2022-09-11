package com.example.books.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthorBook {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public AuthorBook(Author author, Book book) {
        this.author = author;
        this.book = book;
    }
}
