package com.example.neohackproject.repositories;

import com.example.neohackproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByName(String name);
    Optional<Author> findBySurname(String surname);

    Optional<List<Author>> findAllByName(String name);
    Optional<List<Author>> findAllBySurname(String name);
}