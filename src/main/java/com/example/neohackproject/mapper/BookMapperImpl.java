package com.example.neohackproject.mapper;

import com.example.neohackproject.dto.BookDtoForInsert;
import com.example.neohackproject.dto.BookDtoForPresent;
import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Book;
import com.example.neohackproject.model.Category;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
   public BookDtoForPresent mapBookToBookDto(Book b, Category c, Author a){
       return BookDtoForPresent
               .builder()
               .id(b.getId())
               .name(b.getName())
               .isbn(b.getIsbn())
               .dateAdd(b.getDateAdd())
               .dateRemove(b.getDateRemove())
               .category(c)
               .author(a)
               .build();
   }

   @Override
   public Book mapBookDtoToBookEntity(BookDtoForInsert bookDtoForInsert, Category ca, Author a){
        Book book = Book
                .builder()
                .name(bookDtoForInsert.getName())
                .isbn(bookDtoForInsert.getIsbn())
                .dateAdd(bookDtoForInsert.getDateAdd())
                .dateRemove(bookDtoForInsert.getDateRemove())
                .authorId(a.getId())
                .categoryId(ca.getId().longValue())
                .build();
        return book;
   }
   @Override
    public Book mapBookFromDtoToUpdateBook(Book updateBook, Book bookFromDto){
        updateBook.setName(bookFromDto.getName());
        updateBook.setIsbn(bookFromDto.getIsbn());
        updateBook.setDateAdd(bookFromDto.getDateAdd());
        updateBook.setDateRemove(bookFromDto.getDateRemove());
        updateBook.setCategoryId(bookFromDto.getCategoryId());
        updateBook.setAuthorId(bookFromDto.getAuthorId());
        return updateBook;
    }
}
