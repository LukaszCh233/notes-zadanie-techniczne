package com.notes_zadanie_techniczne.service;

import com.notes_zadanie_techniczne.dto.NoteDTO;
import com.notes_zadanie_techniczne.dto.NoteRequest;
import com.notes_zadanie_techniczne.entity.Author;
import com.notes_zadanie_techniczne.entity.Note;
import com.notes_zadanie_techniczne.mapper.EntityMapper;
import com.notes_zadanie_techniczne.repository.AuthorRepository;
import com.notes_zadanie_techniczne.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;
    private final EntityMapper entityMapper;

    public NoteService(NoteRepository noteRepository, AuthorRepository authorRepository, EntityMapper entityMapper) {
        this.noteRepository = noteRepository;
        this.authorRepository = authorRepository;
        this.entityMapper = entityMapper;
    }

    public void createNote(NoteRequest noteRequest) {
        Author author = authorRepository.findById(noteRequest.getAuthorId()).orElseThrow(()
                -> new EntityNotFoundException("Not found author with this id"));

        Note note = new Note();
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
        note.setAuthor(author);

        noteRepository.save(note);
    }

    public List<NoteDTO> findAllNotes() {
        List<Note> notes = noteRepository.findAll();

        return entityMapper.mapNotesListToNotesListDTO(notes);
    }

    public NoteDTO findNoteById(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Not found note with this id"));

        return entityMapper.mapNoteToNoteDTO(note);
    }

    public void deleteNoteById(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new EntityNotFoundException("Not found note with this id");
        }
        noteRepository.deleteById(id);
    }
}

