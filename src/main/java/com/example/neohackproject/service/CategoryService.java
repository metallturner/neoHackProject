package com.example.neohackproject.service;

import com.example.neohackproject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    Category findByName(String name);
    List<Category> findAllByName(String name);
    void saveCategory(Category category);
}
