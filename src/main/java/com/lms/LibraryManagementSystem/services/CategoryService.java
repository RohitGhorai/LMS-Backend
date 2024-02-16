package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Category;
import com.lms.LibraryManagementSystem.payloads.CategoryDto;

import java.util.*;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    List<CategoryDto> getAllCategories();
    Category getBooksByCategory(int catId);
}
