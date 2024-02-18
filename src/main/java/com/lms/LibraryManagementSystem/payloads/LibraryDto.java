package com.lms.LibraryManagementSystem.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibraryDto {
    private int id;
    private FacultyDto faculty;
    private String content;
    private String email;
}
