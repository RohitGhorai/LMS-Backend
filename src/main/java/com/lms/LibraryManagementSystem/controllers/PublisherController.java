package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Publisher;
import com.lms.LibraryManagementSystem.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/")
    public ResponseEntity<Publisher> registerPublisher(@RequestBody Publisher publisher){
        return new ResponseEntity<>(this.publisherService.registerPublisher(publisher), HttpStatus.CREATED);
    }

    @PutMapping("/{pubId}")
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher, @PathVariable int pubId){
        return ResponseEntity.ok(this.publisherService.updatePublisher(publisher, pubId));
    }
}
