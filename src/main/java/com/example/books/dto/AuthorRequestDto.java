package com.example.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AuthorRequestDto {
    @Schema(description = "Required")
    private String name;
    @Schema(description = "Required / Example: 2022-09-12")
    private LocalDate birth;

    public AuthorRequestDto(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }
}
