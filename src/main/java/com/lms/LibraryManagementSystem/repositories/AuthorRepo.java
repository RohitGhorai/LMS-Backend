package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
