package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Faculty faculty;
    private String content;
    private String email;
}
