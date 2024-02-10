package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
