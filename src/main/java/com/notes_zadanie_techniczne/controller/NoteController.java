package com.notes_zadanie_techniczne.controller;

import com.notes_zadanie_techniczne.dto.NoteDTO;
import com.notes_zadanie_techniczne.dto.NoteRequest;
import com.notes_zadanie_techniczne.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<String> createNote(@Valid @RequestBody NoteRequest noteRequest) {
        noteService.createNote(noteRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Note has been created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable Long id) {
        NoteDTO note = noteService.findNoteById(id);

        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<NoteDTO>> getNotes() {
        List<NoteDTO> notes = noteService.findAllNotes();

        return ResponseEntity.ok(notes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);

        return ResponseEntity.ok("Note has been deleted");
    }
}
