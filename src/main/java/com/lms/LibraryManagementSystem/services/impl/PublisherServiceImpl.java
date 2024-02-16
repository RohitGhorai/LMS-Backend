package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Publisher;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.repositories.PublisherRepo;
import com.lms.LibraryManagementSystem.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public Publisher registerPublisher(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher, int publisherId) {
        Publisher p1 = this.publisherRepo.findById(publisherId).orElseThrow(() -> new ResourceNotFoundException("Publisher", "Id", publisherId));
        p1.setEmailId(publisher.getEmailId());
        p1.setLocation(publisher.getLocation());
        return this.publisherRepo.save(p1);
    }
}
