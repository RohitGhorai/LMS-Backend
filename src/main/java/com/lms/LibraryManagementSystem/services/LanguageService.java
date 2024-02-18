package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.payloads.LanguageDto;

import java.util.List;

public interface LanguageService {
    // add
    // getAll
    LanguageDto addLanguage(LanguageDto language);
    List<LanguageDto> getAllLanguages();
}
