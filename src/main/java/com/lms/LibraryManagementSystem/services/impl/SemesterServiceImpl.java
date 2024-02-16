package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Semester;
import com.lms.LibraryManagementSystem.payloads.SemesterDto;
import com.lms.LibraryManagementSystem.repositories.SemesterRepo;
import com.lms.LibraryManagementSystem.services.SemesterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SemesterRepo semesterRepo;

    @Override
    public SemesterDto createSemester(SemesterDto semesterDto) {
        Semester semester = this.modelMapper.map(semesterDto, Semester.class);
        Semester create = this.semesterRepo.save(semester);
        return this.modelMapper.map(create, SemesterDto.class);
    }

    @Override
    public List<SemesterDto> getAllSemesters() {
        List<Semester> getAllSem = this.semesterRepo.findAll();
        List<SemesterDto> semDtos = getAllSem.stream().map(sem -> this.modelMapper.map(sem, SemesterDto.class)).collect(Collectors.toList());
        return semDtos;
    }
}
