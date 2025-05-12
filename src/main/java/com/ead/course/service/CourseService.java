package com.ead.course.service;

import com.ead.course.dtos.response.CourseRecordDto;
import com.ead.course.model.CourseModel;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

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

    Page<CourseModel> findAll(Specification<CourseModel> spec, Pageable pageable);
}
