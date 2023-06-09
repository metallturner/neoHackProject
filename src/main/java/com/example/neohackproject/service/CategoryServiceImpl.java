package com.example.neohackproject.service;

import com.example.neohackproject.model.Category;
import com.example.neohackproject.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @Override
   public Category findById(int id){
        return categoryRepository.findById(id).orElse(null);
   }

    @Override
    public Category findByName(String name){
        return categoryRepository.findByName(name).orElse(null);
    }
    @Override
    public List<Category> findAllByName(String name){
       return categoryRepository.findAllByName(name).orElse(null);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

}
