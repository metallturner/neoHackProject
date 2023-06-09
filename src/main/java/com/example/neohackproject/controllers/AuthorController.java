package com.example.neohackproject.controllers;
import com.example.neohackproject.model.Author;
import com.example.neohackproject.service.AuthorService;
import com.example.neohackproject.utils.Authorization;
import com.example.neohackproject.utils.AuthorizationEx;
import com.example.neohackproject.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
   private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    ResponseEntity<Set<Author>> findAll(){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }

        return new ResponseEntity<>(new LinkedHashSet<>(authorService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<Set<Author>> findAllByName(@PathVariable("name") String name){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(new LinkedHashSet<>(authorService.findAllByName(name)), HttpStatus.OK);
    }

    @GetMapping("/surname/{name}")
    ResponseEntity<Set<Author>> findAllBysurname(@PathVariable("name") String name){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(new LinkedHashSet<>(authorService.findAllBySurname(name)), HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleEx(AuthorizationEx ex){
        ErrorResponse errorResponse = new ErrorResponse("Authorization failed");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
