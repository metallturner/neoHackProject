package com.example.neohackproject.repositories;

import com.example.neohackproject.model.BookToHand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookToHandRepository extends JpaRepository<BookToHand, Integer> {
}