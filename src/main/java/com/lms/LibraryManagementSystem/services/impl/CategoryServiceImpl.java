package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Category;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.payloads.CategoryDto;
import com.lms.LibraryManagementSystem.repositories.CategoryRepo;
import com.lms.LibraryManagementSystem.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        return this.modelMapper.map(this.categoryRepo.save(this.modelMapper.map(category, Category.class)), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return this.categoryRepo.findAll().stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public Category getBooksByCategory(int catId) {
        return this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catId));
    }
}
