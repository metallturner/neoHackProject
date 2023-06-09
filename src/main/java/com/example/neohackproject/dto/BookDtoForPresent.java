package com.example.neohackproject.dto;

import com.example.neohackproject.model.Author;
import com.example.neohackproject.model.Category;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.neohackproject.model.Book} entity
 */
@Data
@Builder
public class BookDtoForPresent implements Serializable {
    private final Integer id;
    private final String name;
    private final String isbn;
    private final String dateAdd;
    private final String dateRemove;
    private final Category category;
    private final Author author;
}