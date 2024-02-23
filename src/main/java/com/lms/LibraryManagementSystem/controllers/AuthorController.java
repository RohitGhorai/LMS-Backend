package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Author;
import com.lms.LibraryManagementSystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(this.authorService.registerAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(this.authorService.getAllAuthors());
    }
}
