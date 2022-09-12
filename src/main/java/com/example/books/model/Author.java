package com.example.books.model;

import com.example.books.dto.AuthorRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Column @NotBlank @Size(min=1, max=255)
    private String name;
    @Column
    private LocalDate birth;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Author(AuthorRequestDto authorRequestDto) {
        this.name = authorRequestDto.getName();
        this.birth = authorRequestDto.getBirth();
    }
}
