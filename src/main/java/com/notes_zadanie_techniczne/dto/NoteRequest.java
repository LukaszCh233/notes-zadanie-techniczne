package com.notes_zadanie_techniczne.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NoteRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    private String content;

    @NotNull(message = "Author ID is required")
    private Long authorId;
}
