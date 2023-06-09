package com.example.neohackproject.repositories;

import com.example.neohackproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
    Optional<List<Category>> findAllByName(String name);
}