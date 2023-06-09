package com.example.neohackproject.mapper;

import com.example.neohackproject.dto.BookDtoForInsert;
import com.example.neohackproject.dto.BookDtoForPresent;
import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Book;
import com.example.neohackproject.model.Category;

public interface BookMapper {
    BookDtoForPresent mapBookToBookDto(Book b, Category c, Author a);
    Book mapBookDtoToBookEntity(BookDtoForInsert bookDtoForInsert, Category ca, Author a);
    Book mapBookFromDtoToUpdateBook(Book updateBook, Book bookFromDto);
}
