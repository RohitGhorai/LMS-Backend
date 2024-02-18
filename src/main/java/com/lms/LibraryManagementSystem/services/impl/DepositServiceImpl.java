package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Copies;
import com.lms.LibraryManagementSystem.entities.Deposit;
import com.lms.LibraryManagementSystem.entities.User;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.repositories.CopiesRepo;
import com.lms.LibraryManagementSystem.repositories.DepositRepo;
import com.lms.LibraryManagementSystem.repositories.UserRepo;
import com.lms.LibraryManagementSystem.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositRepo depositRepo;
    @Autowired
    private CopiesRepo copiesRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public Deposit addBook(Deposit deposit, String userId, int copyId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id : " + userId, 0));
        Copies copies = this.copiesRepo.findById(copyId).orElseThrow(() -> new ResourceNotFoundException("Copy", "Id", copyId));
        deposit.setUser(user);
        deposit.setCopy(copies);
        return this.depositRepo.save(deposit);
    }

    @Override
    public Deposit getById(long depositId) {
        return this.depositRepo.findById(depositId).orElseThrow(() -> new ResourceNotFoundException("Deposit", "Id", depositId));
    }
}
