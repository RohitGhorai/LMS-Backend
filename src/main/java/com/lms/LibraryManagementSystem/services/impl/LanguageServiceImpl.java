package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Language;
import com.lms.LibraryManagementSystem.payloads.LanguageDto;
import com.lms.LibraryManagementSystem.repositories.LanguageRepo;
import com.lms.LibraryManagementSystem.services.LanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LanguageDto addLanguage(LanguageDto language) {
        return this.modelMapper.map(this.languageRepo.save(this.modelMapper.map(language, Language.class)), LanguageDto.class);
    }

    @Override
    public List<LanguageDto> getAllLanguages() {
        return this.languageRepo.findAll().stream().map(lan -> this.modelMapper.map(lan, LanguageDto.class)).collect(Collectors.toList());
    }
}
