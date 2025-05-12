package com.ead.course.service;

import com.ead.course.model.CourseModel;
import com.ead.course.model.CourseUserModel;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface CourseUserService {
    boolean existByCourseAndUserId(CourseModel courseModel, UUID userId);
    CourseUserModel saveAndSendSubscriptionUserInCourse(CourseUserModel courseUserModel);
}
