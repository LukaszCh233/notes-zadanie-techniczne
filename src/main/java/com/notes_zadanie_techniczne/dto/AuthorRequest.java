package com.notes_zadanie_techniczne.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
}
