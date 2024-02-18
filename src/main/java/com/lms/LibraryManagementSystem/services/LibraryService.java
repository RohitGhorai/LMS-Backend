package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Library;
import com.lms.LibraryManagementSystem.payloads.LibraryDto;

import java.util.List;

public interface LibraryService {
    LibraryDto createLibrary(LibraryDto libraryDto);
    LibraryDto updateLibrary(LibraryDto libraryDto, int libId, int facultyId);
    LibraryDto getLibraryById(int libraryId);
    List<LibraryDto> getAllLibraries();
    // search
}
