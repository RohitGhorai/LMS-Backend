package com.lms.LibraryManagementSystem.helper;

import com.lms.LibraryManagementSystem.entities.User;
import com.lms.LibraryManagementSystem.exceptions.ApiException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import java.io.Serializable;
import java.time.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.hibernate.HibernateException;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {
    private static final AtomicInteger count = new AtomicInteger(0);
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object instanceof User) {
            User user = (User) object;
            int currentYear = Year.now().getValue();
            StringBuilder sb = new StringBuilder(currentYear);
            // Generate the custom ID using the year and name
            sb.append(user.getSemester().getId());
            sb.append(count.incrementAndGet());
            return sb.toString();
        }
        else {
            return new ApiException("Invalid entity type for custom ID generation.");
        }
    }
}