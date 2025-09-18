package com.notes_zadanie_techniczne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @PrePersist
    public void setDate() {
        createdAt = LocalDateTime.now();
    }
}
