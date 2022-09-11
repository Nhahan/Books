package com.example.books.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;
    @Column @NotBlank
    private String name;
    @Column
    private LocalDate birth;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updatedAt;
}
