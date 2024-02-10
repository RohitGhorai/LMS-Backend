package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private List<Book> books = new ArrayList<>();
}
