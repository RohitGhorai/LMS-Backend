package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String language;
    @OneToMany
    private List<Book> books = new ArrayList<>();
}
