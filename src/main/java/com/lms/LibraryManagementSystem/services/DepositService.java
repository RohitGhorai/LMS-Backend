package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Deposit;

public interface DepositService {
    Deposit addBook(Deposit deposit, long userId, int copyId);
    Deposit getById(long depositId);
}
