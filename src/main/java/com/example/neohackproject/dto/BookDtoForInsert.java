package com.example.neohackproject.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.neohackproject.model.Book} entity
 */
@Data
public class BookDtoForInsert implements Serializable {
    private final Integer id;
    private final String name;
    private final String isbn;
    private final String dateAdd;
    private final String dateRemove;
    private final String categoryName;
    private final String authorName;
    private final String authorSurname;
    private final String authorPatronymic;
}