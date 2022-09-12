package com.example.books.repository;

import com.example.books.model.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long> {
    @Query("select ab from AuthorBook ab left join Author as a on ab.author.id = a.id where ab.book.id = :id")
    List<AuthorBook> findAllByBookId(@Param("id") Long id);

}
