package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Copies;
import com.lms.LibraryManagementSystem.services.CopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/copies")
public class CopiesController {

    @Autowired
    private CopiesService copiesService;

    @PostMapping("/books/{bookId}")
    public ResponseEntity<Copies> addCopy(@RequestBody Copies copy, @PathVariable int bookId){
        return new ResponseEntity<>(this.copiesService.addCopy(copy, bookId), HttpStatus.CREATED);
    }

    @GetMapping("/{copyId}")
    public ResponseEntity<Copies> getCopyById(@PathVariable int copyId){
        return ResponseEntity.ok(this.copiesService.getCopyById(copyId));
    }

    @PutMapping("/{copyId}")
    public ResponseEntity<Copies> updateCopy(@RequestBody Copies copy, @PathVariable int copyId){
        return ResponseEntity.ok(this.copiesService.updateCopy(copy, copyId));
    }
}
