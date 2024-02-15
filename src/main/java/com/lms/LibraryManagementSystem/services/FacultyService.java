package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.payloads.FacultyDto;

import java.util.List;

public interface FacultyService {
    FacultyDto createFaculty(FacultyDto facultyDto);
    List<FacultyDto> getAllFaculty();
    void deleteFaculty(int facultyId);
}
