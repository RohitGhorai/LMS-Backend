package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto register(UserDto userDto, int semId, int facultyId);
    UserDto update(UserDto userDto, String userId);
    UserDto getUserById(String userId);
    List<UserDto> getAllUser();
    void deleteUser(String userId);
}
