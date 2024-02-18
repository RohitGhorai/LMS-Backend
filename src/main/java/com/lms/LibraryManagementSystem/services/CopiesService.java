package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Copies;

public interface CopiesService {
    // create
    // update
    Copies addCopy(Copies copy, int bookId);
    Copies updateCopy(Copies copy, int copyId);
    Copies getCopyById(int copyId);
}
