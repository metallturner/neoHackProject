package com.example.neohackproject.controllers;
import com.example.neohackproject.dto.BookDtoForInsert;
import com.example.neohackproject.dto.BookDtoForPresent;
import com.example.neohackproject.model.Credential;
import com.example.neohackproject.model.Employee;
import com.example.neohackproject.service.BookService;
import com.example.neohackproject.service.EmployeeService;
import com.example.neohackproject.utils.Authorization;
import com.example.neohackproject.utils.AuthorizationEx;
import com.example.neohackproject.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService, EmployeeService employeeService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    ResponseEntity<List<BookDtoForPresent>> findAll() {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<BookDtoForPresent> findById(@PathVariable("id") int id) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/author/{name}")
    ResponseEntity<List<BookDtoForPresent>> findByAuthorName(@PathVariable("name") String name) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(bookService.findAllByAuthorName(name), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    ResponseEntity<BookDtoForPresent> findByCategoryId(@PathVariable("id") int id) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(bookService.findByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/authorid/{id}")
    ResponseEntity<BookDtoForPresent> findByAuthorId(@PathVariable("id") int id) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        return new ResponseEntity<>(bookService.findByAuthorId(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<HttpStatus> saveBook(@RequestBody BookDtoForInsert bookDtoForInsert) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        bookService.saveBook(bookDtoForInsert);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<HttpStatus> updateBook(@RequestBody BookDtoForInsert bookDtoForInsert) {
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        bookService.updateBook(bookDtoForInsert);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
        ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id){
        if(!Authorization.isAuthorization){
            throw new AuthorizationEx();
        }
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleEx(AuthorizationEx ex){
        ErrorResponse errorResponse = new ErrorResponse("Authorization failed");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    }

