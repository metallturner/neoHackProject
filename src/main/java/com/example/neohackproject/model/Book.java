package com.example.neohackproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "book")
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "isbn", length = Integer.MAX_VALUE)
    private String isbn;

    @Column(name = "date_add", length = Integer.MAX_VALUE)
    private String dateAdd;

    @Column(name = "date_remove", length = Integer.MAX_VALUE)
    private String dateRemove;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "author_id")
    private Integer authorId;

}
