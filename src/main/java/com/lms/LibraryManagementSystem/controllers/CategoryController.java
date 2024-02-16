package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Category;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.payloads.CategoryDto;
import com.lms.LibraryManagementSystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category){
        CategoryDto create = this.categoryService.createCategory(category);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @GetMapping("/{catId}")
    public ResponseEntity<Category> getBooksByCategory(@PathVariable int catId){
        return ResponseEntity.ok(this.categoryService.getBooksByCategory(catId));
    }
}
