package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.payloads.LanguageDto;
import com.lms.LibraryManagementSystem.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/")
    public ResponseEntity<LanguageDto> addLanguage(@RequestBody LanguageDto language){
        return new ResponseEntity<>(this.languageService.addLanguage(language), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<LanguageDto>> getAllLanguages(){
        return ResponseEntity.ok(this.languageService.getAllLanguages());
    }
}
