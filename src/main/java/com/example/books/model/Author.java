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
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id") @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column @NotBlank
    private String name;
    @Column
    private LocalDate birth;
    @CreationTimestamp @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date createAt;
    @CreationTimestamp @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Date updatedAt;

    public Author(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }
}
