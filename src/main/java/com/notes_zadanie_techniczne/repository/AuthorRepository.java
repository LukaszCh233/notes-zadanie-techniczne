package com.notes_zadanie_techniczne.repository;

import com.notes_zadanie_techniczne.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
