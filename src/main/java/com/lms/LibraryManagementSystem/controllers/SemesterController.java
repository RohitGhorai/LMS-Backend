package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.payloads.ApiResponse;
import com.lms.LibraryManagementSystem.payloads.SemesterDto;
import com.lms.LibraryManagementSystem.payloads.UserDto;
import com.lms.LibraryManagementSystem.services.SemesterService;
import com.lms.LibraryManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/semesters")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @PostMapping("/")
    public ResponseEntity<SemesterDto> createSemester(@RequestBody SemesterDto semester){
        SemesterDto semesterDto = this.semesterService.createSemester(semester);
        return new ResponseEntity<>(semesterDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<SemesterDto>> getAllSem(){
        return ResponseEntity.ok(this.semesterService.getAllSemesters());
    }
}
