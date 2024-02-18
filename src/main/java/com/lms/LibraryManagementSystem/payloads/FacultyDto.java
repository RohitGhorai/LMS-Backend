package com.lms.LibraryManagementSystem.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacultyDto {
    private int id;
    private String faculty;
    private String facultyPersian;
}
