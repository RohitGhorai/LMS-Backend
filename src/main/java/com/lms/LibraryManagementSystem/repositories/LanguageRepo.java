package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language, Integer> {
}
