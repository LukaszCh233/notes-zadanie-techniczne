package com.notes_zadanie_techniczne.controller;

import com.notes_zadanie_techniczne.dto.AuthorDTO;
import com.notes_zadanie_techniczne.dto.AuthorRequest;
import com.notes_zadanie_techniczne.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<String> createNewAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        authorService.createAuthor(authorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author has been created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        AuthorDTO author = authorService.findAuthorById(id);

        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAuthors() {
        List<AuthorDTO> authors = authorService.findAuthorsList();

        return ResponseEntity.ok(authors);
    }
}
