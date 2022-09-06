package com.example.books.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authors")
@Getter
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column @NotNull
    private String name;
    @Column @NotNull
    private Date birth;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updatedAt;
}
