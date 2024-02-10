package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String isbn;
    private String pages;
    private String language;
    private int edition;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private int publicationYear;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;
    private String description;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Copies> copies = new ArrayList<>();
}
