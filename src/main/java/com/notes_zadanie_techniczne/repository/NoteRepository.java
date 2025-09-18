package com.notes_zadanie_techniczne.repository;

import com.notes_zadanie_techniczne.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
