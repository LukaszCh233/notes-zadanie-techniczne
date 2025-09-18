package com.notes_zadanie_techniczne.mapper;

import com.notes_zadanie_techniczne.dto.AuthorDTO;
import com.notes_zadanie_techniczne.dto.NoteDTO;
import com.notes_zadanie_techniczne.entity.Author;
import com.notes_zadanie_techniczne.entity.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {
    public AuthorDTO mapAuthorToAuthorDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }

    public List<AuthorDTO> mapAuthorsListToAuthorsListDTO(List<Author> authors) {
        return authors.stream()
                .map(this::mapAuthorToAuthorDTO)
                .collect(Collectors.toList());
    }

    public NoteDTO mapNoteToNoteDTO(Note note) {
        return new NoteDTO(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(),
                note.getAuthor().getId(), note.getAuthor().getName());
    }

    public List<NoteDTO> mapNotesListToNotesListDTO(List<Note> notes) {
        return notes.stream()
                .map(this::mapNoteToNoteDTO)
                .collect(Collectors.toList());
    }
}
