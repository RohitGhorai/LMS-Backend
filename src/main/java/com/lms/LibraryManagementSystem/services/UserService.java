package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto register(UserDto userDto, int semId, int facultyId, int cityId);
    UserDto update(UserDto userDto, long userId);
    UserDto getUserById(long userId);
    List<UserDto> getAllUser();
    void deleteUser(long userId);
}
