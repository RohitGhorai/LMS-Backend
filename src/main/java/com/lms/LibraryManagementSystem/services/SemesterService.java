package com.lms.LibraryManagementSystem.services;


import com.lms.LibraryManagementSystem.payloads.SemesterDto;

import java.util.List;

public interface SemesterService {
    SemesterDto createSemeter(SemesterDto semesterDto);
    List<SemesterDto> getAllSemester();
}
