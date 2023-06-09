package com.example.neohackproject.repositories;

import com.example.neohackproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByCategoryId(int id);
    Optional<Book> findByAuthorId(int id);
}