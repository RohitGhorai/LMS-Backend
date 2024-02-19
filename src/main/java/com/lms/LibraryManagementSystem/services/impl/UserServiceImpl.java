package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.City;
import com.lms.LibraryManagementSystem.entities.Faculty;
import com.lms.LibraryManagementSystem.entities.Semester;
import com.lms.LibraryManagementSystem.entities.User;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.payloads.UserDto;
import com.lms.LibraryManagementSystem.repositories.CityRepo;
import com.lms.LibraryManagementSystem.repositories.FacultyRepo;
import com.lms.LibraryManagementSystem.repositories.SemesterRepo;
import com.lms.LibraryManagementSystem.repositories.UserRepo;
import com.lms.LibraryManagementSystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SemesterRepo semesterRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private CityRepo cityRepo;

    @Override
    public UserDto register(UserDto userDto, int semId, int facultyId, int cityId) {
        Semester semester = this.semesterRepo.findById(semId).orElseThrow(() -> new ResourceNotFoundException("Semester", "Id", semId));
        Faculty faculty = this.facultyRepo.findById(facultyId).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", facultyId));
        City city = this.cityRepo.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City", "Id", cityId));
        User user = this.modelMapper.map(userDto, User.class);
        user.setFaculty(faculty);
        user.setSemester(semester);
        user.setCity(city);
        User create = this.userRepo.save(user);
        return this.modelMapper.map(create, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto, long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setEmail(userDto.getEmail());
        user.setContactNo(userDto.getContactNo());
        user.setPassword(userDto.getPassword());
        User update = this.userRepo.save(user);
        return this.modelMapper.map(update, UserDto.class);
    }

    @Override
    public UserDto getUserById(long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUsers = this.userRepo.findAll();
        return allUsers.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(long userId) {
        User delete = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(delete);
    }
}
