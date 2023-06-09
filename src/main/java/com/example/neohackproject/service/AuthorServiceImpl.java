package com.example.neohackproject.service;

import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Category;
import com.example.neohackproject.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
   private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id){
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author findByName(String name){
        return authorRepository.findByName(name).orElse(null);
    }
    public List<Author> findAllByName(String name){
        return authorRepository.findAllByName(name).orElse(null);
    }

    @Override
    public List<Author> findAllBySurname(String name){
        return authorRepository.findAllBySurname(name).orElse(null);
    }

    @Override
    public Author findBySurname(String name){
        return authorRepository.findBySurname(name).orElse(null);
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }


}
