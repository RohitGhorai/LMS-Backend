package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Library;
import com.lms.LibraryManagementSystem.payloads.ApiResponse;
import com.lms.LibraryManagementSystem.payloads.FacultyDto;
import com.lms.LibraryManagementSystem.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/libraries/{libId}")
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody FacultyDto facultyDto, @PathVariable int libId){
        FacultyDto facultyDto1 = this.facultyService.createFaculty(facultyDto, libId);
        return new ResponseEntity<>(facultyDto1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<FacultyDto>> getAllFaculties(){
        List<FacultyDto> facultyDtos1 = this.facultyService.getAllFaculty();
        return ResponseEntity.ok(facultyDtos1);
    }

    @DeleteMapping("/{facId}")
    public ResponseEntity<ApiResponse> deleteFaculty(@PathVariable int facId){
        this.facultyService.deleteFaculty(facId);
        return new ResponseEntity<>(new ApiResponse("Faculty deleted !!", true), HttpStatus.OK);
    }
}
