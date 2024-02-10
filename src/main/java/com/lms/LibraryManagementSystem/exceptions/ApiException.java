package com.lms.LibraryManagementSystem.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
