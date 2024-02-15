package com.lms.LibraryManagementSystem.payloads;

import com.lms.LibraryManagementSystem.entities.Library;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacultyDto {
    private int id;
    private String faculty;
    private String facultyPersian;
    private Library library;
}
