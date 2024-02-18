package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Deposit;
import com.lms.LibraryManagementSystem.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/users/{userId}/copies/{copyId}")
    public ResponseEntity<Deposit> addInDeposit(@RequestBody Deposit deposit, @PathVariable String userId, @PathVariable int copyId){
        return new ResponseEntity<>(this.depositService.addBook(deposit, userId, copyId), HttpStatus.CREATED);
    }

    @GetMapping("/{depositId}")
    public ResponseEntity<Deposit> getById(@PathVariable long depositId){
        return ResponseEntity.ok(this.depositService.getById(depositId));
    }
}
