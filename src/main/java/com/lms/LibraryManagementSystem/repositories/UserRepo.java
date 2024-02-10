package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
