package com.example.neohackproject.service;

import com.example.neohackproject.dto.BookDtoForInsert;
import com.example.neohackproject.dto.BookDtoForPresent;
import com.example.neohackproject.mapper.BookMapper;
import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Book;
import com.example.neohackproject.model.Category;
import com.example.neohackproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookMapper bookMapper;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookMapper = bookMapper;
    }


    @Override
    public List<BookDtoForPresent> findAll() {
        List<Book> list = bookRepository.findAll();
        List<BookDtoForPresent> bookDtoForPresentList = new ArrayList<>();
        for (Book b : list) {
            bookDtoForPresentList.add(bookMapper.mapBookToBookDto(b,
                    categoryService.findById(b.getCategoryId().intValue()),
                    authorService.findById(b.getAuthorId())));
        }
        return bookDtoForPresentList;
    }

    @Override
    public BookDtoForPresent findById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        return bookMapper.mapBookToBookDto(book,
                categoryService.findById(book.getCategoryId().intValue()),
                authorService.findById(book.getAuthorId()));
    }

    @Override
    public List<BookDtoForPresent> findAllByAuthorName(String authorName) {
        Author author = Optional.ofNullable(authorService.findByName(authorName))
                .orElse(authorService.findBySurname(authorName));
        List<Book> listBooks = bookRepository.findAll();
        listBooks.removeIf(book -> !Objects.equals(book.getAuthorId(), author.getId()));
        List<BookDtoForPresent> bookDtoForPresentList = new ArrayList<>();
        for (Book b : listBooks) {
            bookDtoForPresentList.add(bookMapper.mapBookToBookDto(b,
                    categoryService.findById(b.getCategoryId().intValue()),
                    authorService.findById(b.getAuthorId())));
        }
        return bookDtoForPresentList;
    }

    @Override
    public BookDtoForPresent findByCategoryId(int categoryId){
        Book book = bookRepository.findByCategoryId(categoryId).orElse(null);
        return bookMapper.mapBookToBookDto(book,
                categoryService.findById(book.getCategoryId().intValue()),
                authorService.findById(book.getAuthorId()));
    }

    @Override
    public BookDtoForPresent findByAuthorId(int authorId){
        Book book = bookRepository.findByAuthorId(authorId).orElse(null);
        return bookMapper.mapBookToBookDto(book,
                categoryService.findById(book.getCategoryId().intValue()),
                authorService.findById(book.getAuthorId()));
    }

    @Override
    @Transactional
    public void saveBook(BookDtoForInsert bookDtoForInsert){
        Author author = Author
                .builder()
                .name(bookDtoForInsert.getAuthorName())
                .surname(bookDtoForInsert.getAuthorSurname())
                .patronymic(bookDtoForInsert.getAuthorPatronymic())
                .build();
        authorService.saveAuthor(author);
        Category category = Category
                .builder()
                .name(bookDtoForInsert.getCategoryName())
                .build();
        categoryService.saveCategory(category);
       bookRepository.save(bookMapper.mapBookDtoToBookEntity(bookDtoForInsert, category, author));
    }

    @Override
    public void updateBook(BookDtoForInsert bookDtoForInsert){
      Book updateBook = bookRepository.findById(bookDtoForInsert.getId()).orElse(null);
        if (updateBook == null){
            saveBook(bookDtoForInsert);
        }
        else {
            Author author = Author
                    .builder()
                    .name(bookDtoForInsert.getAuthorName())
                    .surname(bookDtoForInsert.getAuthorSurname())
                    .patronymic(bookDtoForInsert.getAuthorPatronymic())
                    .build();
            authorService.saveAuthor(author);
            Category category = Category
                    .builder()
                    .name(bookDtoForInsert.getCategoryName())
                    .build();
            categoryService.saveCategory(category);
            Book bookFromDto = bookMapper.mapBookDtoToBookEntity(bookDtoForInsert, category, author);
            bookMapper.mapBookFromDtoToUpdateBook(updateBook, bookFromDto);
        }
    }

    @Override
    @Transactional
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
