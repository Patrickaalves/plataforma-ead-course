package com.ead.course.service.impl;

import com.ead.course.repositories.CourseUserRepository;
import com.ead.course.service.CourseUserService;
import org.springframework.stereotype.Service;

@Service
public class CourseUserServiceImpl implements CourseUserService {

    final CourseUserRepository courseUserRepository;

    public CourseUserServiceImpl(CourseUserRepository courseUserRepository) {
        this.courseUserRepository = courseUserRepository;
    }
}
