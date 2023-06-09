package com.example.neohackproject.service;

import com.example.neohackproject.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(int id);

    Author findByName(String name);
    List<Author> findAllByName(String name);
    List<Author> findAllBySurname(String name);
    Author findBySurname(String name);
    void saveAuthor(Author author);
}
