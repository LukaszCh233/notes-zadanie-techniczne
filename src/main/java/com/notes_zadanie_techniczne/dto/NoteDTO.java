package com.notes_zadanie_techniczne.dto;

import java.time.LocalDateTime;

public record NoteDTO(Long id, String title, String content, LocalDateTime createdAt, Long authorId, String author) {
}
