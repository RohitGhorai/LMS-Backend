package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Faculty;
import com.lms.LibraryManagementSystem.entities.Library;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.payloads.FacultyDto;
import com.lms.LibraryManagementSystem.repositories.FacultyRepo;
import com.lms.LibraryManagementSystem.repositories.LibraryRepo;
import com.lms.LibraryManagementSystem.services.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private LibraryRepo libraryRepo;
    @Override
    public FacultyDto createFaculty(FacultyDto facultyDto, int libId) {
        Faculty faculty = this.modelMapper.map(facultyDto, Faculty.class);
        Library library = this.libraryRepo.findById(libId).orElseThrow(() -> new ResourceNotFoundException("Library", "Id", libId));
        faculty.setLibrary(library);
        Faculty create = this.facultyRepo.save(faculty);
        return this.modelMapper.map(create, FacultyDto.class);
    }

    @Override
    public List<FacultyDto> getAllFaculty() {
        return this.facultyRepo.findAll().stream().map(faculty -> this.modelMapper.map(faculty, FacultyDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteFaculty(int facultyId) {
        Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", facultyId));
        this.facultyRepo.delete(faculty);
    }
}
