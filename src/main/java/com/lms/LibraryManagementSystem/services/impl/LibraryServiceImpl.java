package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Faculty;
import com.lms.LibraryManagementSystem.entities.Library;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.payloads.LibraryDto;
import com.lms.LibraryManagementSystem.repositories.FacultyRepo;
import com.lms.LibraryManagementSystem.repositories.LibraryRepo;
import com.lms.LibraryManagementSystem.services.LibraryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Override
    public LibraryDto createLibrary(LibraryDto libraryDto) {
        return this.modelMapper.map(this.libraryRepo.save(this.modelMapper.map(libraryDto, Library.class)), LibraryDto.class);
    }

    @Override
    public LibraryDto updateLibrary(LibraryDto libraryDto, int libId, int facultyId) {
        Library library = this.libraryRepo.findById(libId).orElseThrow(() -> new ResourceNotFoundException("Library", "Id", libId));
        Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", facultyId));
        library.setFaculty(faculty);
        library.setEmail(libraryDto.getEmail());
        library.setContent(libraryDto.getContent());
        return this.modelMapper.map(this.libraryRepo.save(library), LibraryDto.class);
    }

    @Override
    public LibraryDto getLibraryById(int libraryId) {
        return this.modelMapper.map(this.libraryRepo.findById(libraryId).orElseThrow(() -> new ResourceNotFoundException("Library", "Id", libraryId)), LibraryDto.class);
    }

    @Override
    public List<LibraryDto> getAllLibraries() {
        return this.libraryRepo.findAll().stream().map(library -> this.modelMapper.map(library, LibraryDto.class)).collect(Collectors.toList());
    }
}
