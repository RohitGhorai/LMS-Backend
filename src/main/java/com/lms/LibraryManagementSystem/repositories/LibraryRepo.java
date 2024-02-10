package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Integer> {
}
