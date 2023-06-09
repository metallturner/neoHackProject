package com.example.neohackproject.service;

import com.example.neohackproject.dto.BookDtoForInsert;
import com.example.neohackproject.dto.BookDtoForPresent;
import com.example.neohackproject.model.Book;

import java.util.List;

public interface BookService {
    List<BookDtoForPresent> findAll();
    BookDtoForPresent findById(int id);
    List<BookDtoForPresent> findAllByAuthorName(String authorName);
    BookDtoForPresent findByCategoryId(int categoryId);
    BookDtoForPresent findByAuthorId(int authorId);
    void saveBook(BookDtoForInsert bookDtoForInsert);
    void updateBook(BookDtoForInsert bookDtoForInsert);
    void deleteBook(int id);
}
