package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String faculty;
    private String facultyPersian;
    @OneToOne
    private Library library;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> user = new HashSet<>();
}
