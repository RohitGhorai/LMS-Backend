package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Copies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    private int available;
    private String status;
}
