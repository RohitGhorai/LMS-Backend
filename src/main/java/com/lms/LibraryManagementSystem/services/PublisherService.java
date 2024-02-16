package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Publisher;

public interface PublisherService {
    Publisher registerPublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher, int publisherId);
}
