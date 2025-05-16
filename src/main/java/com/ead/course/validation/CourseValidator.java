package com.ead.course.validation;

import com.ead.course.dtos.response.CourseRecordDto;
import com.ead.course.service.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {

    Logger logger = LogManager.getLogger(CourseValidator.class);

    private final Validator validator;
    final CourseService courseService;

    public CourseValidator(@Qualifier("defaultValidator") Validator validator, CourseService courseService) {
        this.validator = validator;
        this.courseService = courseService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        CourseRecordDto courseRecordDto = (CourseRecordDto) o;
        validator.validate(courseRecordDto, errors);
        if (!errors.hasErrors()) {
            validateCourseName(courseRecordDto, errors);
        }
    }

    private void validateCourseName(CourseRecordDto courseRecordDto, Errors errors ) {
        if (courseService.existsByName(courseRecordDto.name())) {
           errors.rejectValue("name", "courseNameConflict", "Course name is already taken");
           logger.error("Error validation courseName", courseRecordDto.name());
        }
    }
}
