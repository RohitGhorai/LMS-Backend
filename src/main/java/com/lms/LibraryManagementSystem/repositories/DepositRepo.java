package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepo extends JpaRepository<Deposit, Long> {
}
