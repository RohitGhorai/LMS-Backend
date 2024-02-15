package com.lms.LibraryManagementSystem.payloads;

import com.lms.LibraryManagementSystem.entities.Faculty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibraryDto {
    private int id;
    private Faculty faculty;
    private String content;
    private String email;
}
