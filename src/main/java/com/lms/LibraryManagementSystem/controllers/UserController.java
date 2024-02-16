package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.payloads.ApiResponse;
import com.lms.LibraryManagementSystem.payloads.UserDto;
import com.lms.LibraryManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/semesters/{semId}/faculties/{facId}")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto, @PathVariable int semId, @PathVariable int facId){
        UserDto saveUser = this.userService.register(userDto, semId, facId);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable String userId){
        UserDto update = this.userService.update(userDto, userId);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        UserDto getUser = this.userService.getUserById(userId);
        return ResponseEntity.ok(getUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> getAll = this.userService.getAllUser();
        return ResponseEntity.ok(getAll);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted !", true), HttpStatus.OK);
    }
}
