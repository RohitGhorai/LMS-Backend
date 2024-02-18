package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Publisher;
import java.util.List;

public interface PublisherService {
    Publisher registerPublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher, int publisherId);
    List<Publisher> getAllPublishers();
}
