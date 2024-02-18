package com.lms.LibraryManagementSystem.payloads;

import com.lms.LibraryManagementSystem.entities.City;
import com.lms.LibraryManagementSystem.entities.Faculty;
import com.lms.LibraryManagementSystem.entities.Semester;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String fatherName;
    private String email;
    private String contactNo;
    private String regNo;
    private String address;
    private String userName;
    private String password;
    private SemesterDto semester;
    private FacultyDto faculty;
    private City city;
}
