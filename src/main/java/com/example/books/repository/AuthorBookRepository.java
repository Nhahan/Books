package com.example.books.repository;

import com.example.books.model.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long> {
    @Modifying
    @Query("select ab from AuthorBook ab left join fetch Author as a on ab.author.id = a.id where ab.book.id in :ids")
    List<AuthorBook> findAllByBookIds(@Param("ids") List<Long> ids);

}
