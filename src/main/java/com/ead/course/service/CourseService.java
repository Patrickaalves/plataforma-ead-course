package com.ead.course.service;

import com.ead.course.dtos.CourseRecordDto;
import com.ead.course.model.CourseModel;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    void delete(CourseModel courseModel);

    CourseModel save(CourseRecordDto courseRecordDto);

    boolean existsByName(String name);

    List<CourseModel> findAll();

    Optional<CourseModel> findById(UUID id);

    CourseModel update(@Valid CourseRecordDto courseRecordDto, CourseModel courseModel);
}
