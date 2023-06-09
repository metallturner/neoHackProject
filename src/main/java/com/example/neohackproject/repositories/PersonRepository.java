package com.example.neohackproject.repositories;

import com.example.neohackproject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}