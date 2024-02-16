package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.payloads.LibraryDto;
import com.lms.LibraryManagementSystem.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/")
    public ResponseEntity<LibraryDto> createLibrary(@RequestBody LibraryDto libraryDto){
        return new ResponseEntity<>(this.libraryService.createLibrary(libraryDto), HttpStatus.CREATED);
    }

    @PutMapping("/libraries/{libId}/faculties/{facId}")
    public ResponseEntity<LibraryDto> updateLibrary(@RequestBody LibraryDto libraryDto, @PathVariable int libId, @PathVariable int facId){
        return ResponseEntity.ok(this.libraryService.updateLibrary(libraryDto, libId, facId));
    }

    @GetMapping("/{libId}")
    public ResponseEntity<LibraryDto> getLibById(@PathVariable int libId){
        return ResponseEntity.ok(this.libraryService.getLibraryById(libId));
    }

    @GetMapping("/")
    public ResponseEntity<List<LibraryDto>> getAllLib(){
        return ResponseEntity.ok(this.libraryService.getAllLibraries());
    }
}
