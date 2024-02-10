package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String semester;
    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
