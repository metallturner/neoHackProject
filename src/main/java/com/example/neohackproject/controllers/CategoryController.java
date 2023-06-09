package com.example.neohackproject.controllers;

import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Category;
import com.example.neohackproject.service.CategoryService;
import com.example.neohackproject.utils.Authorization;
import com.example.neohackproject.utils.AuthorizationEx;
import com.example.neohackproject.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/all")
    ResponseEntity<Set<Category>> findAll(){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }

        return new ResponseEntity<>(new LinkedHashSet<>(categoryService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<Set<Category>> findAllByName(@PathVariable("name") String name){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(new LinkedHashSet<>(categoryService.findAllByName(name)), HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleEx(AuthorizationEx ex){
        ErrorResponse errorResponse = new ErrorResponse("Authorization failed");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
