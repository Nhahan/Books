package com.example.books.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Author")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;
    @Column @NotBlank @Schema(description = "name", nullable = false)
    private String name;
    @Column @Schema(description = "birth", nullable = false)
    private LocalDate birth;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updatedAt;

    public Author(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }
}
