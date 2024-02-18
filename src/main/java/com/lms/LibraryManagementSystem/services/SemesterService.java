package com.lms.LibraryManagementSystem.services;


import com.lms.LibraryManagementSystem.payloads.SemesterDto;

import java.util.List;

public interface SemesterService {
    SemesterDto createSemester(SemesterDto semesterDto);
    // List<SemesterDto> addAllSem(List<SemesterDto> semesters);
    List<SemesterDto> getAllSemesters();
}
