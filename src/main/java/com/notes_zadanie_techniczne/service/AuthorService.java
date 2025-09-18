package com.notes_zadanie_techniczne.service;

import com.notes_zadanie_techniczne.dto.AuthorDTO;
import com.notes_zadanie_techniczne.dto.AuthorRequest;
import com.notes_zadanie_techniczne.entity.Author;
import com.notes_zadanie_techniczne.mapper.EntityMapper;
import com.notes_zadanie_techniczne.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final EntityMapper entityMapper;

    public AuthorService(AuthorRepository authorRepository, EntityMapper entityMapper) {
        this.authorRepository = authorRepository;
        this.entityMapper = entityMapper;
    }

    public void createAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());

        authorRepository.save(author);
    }

    public AuthorDTO findAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Not found author with this id"));

        return entityMapper.mapAuthorToAuthorDTO(author);
    }

    public List<AuthorDTO> findAuthorsList() {
        List<Author> authors = authorRepository.findAll();

        return entityMapper.mapAuthorsListToAuthorsListDTO(authors);
    }
}
