package com.ead.course.controllers;

import com.ead.course.dtos.response.CourseRecordDto;
import com.ead.course.exceptions.GlobalExceptionHandler;
import com.ead.course.model.CourseModel;
import com.ead.course.service.CourseService;
import com.ead.course.specifications.SpecificationTemplate;
import com.ead.course.validation.CourseValidator;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    final CourseService courseService;
    final CourseValidator courseValidator;

    public CourseController(CourseService courseService, CourseValidator courseValidator) {
        this.courseService = courseService;
        this.courseValidator = courseValidator;
    }

    @PostMapping
    public ResponseEntity<Object> saveCourse(@RequestBody CourseRecordDto courseRecordDto,
                                             Errors errors) {
        logger.debug("POST saveCourse courseRecordDto received {}", courseRecordDto.toString());
        courseValidator.validate(courseRecordDto, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseRecordDto));
    }

    @GetMapping
    public ResponseEntity<Page<CourseModel>> getAllCourses(SpecificationTemplate.CourseSpec spec,
                                                           Pageable pageable,
                                                           @RequestParam(required = false) UUID userId) {
        Page<CourseModel> courseModelPage = (userId != null)
                ? courseService.findAll(SpecificationTemplate.courseUserId(userId).and(spec), pageable)
                : courseService.findAll(spec, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(courseModelPage);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Object> getOneCourse(@PathVariable(value = "courseId") UUID courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(courseId).get());
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "courseId") UUID courseId) {
        logger.debug("DELETE deleteCourse courseId {}", courseId);
        courseService.delete(courseService.findById(courseId).get());
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Object> updateCourse(@PathVariable(value = "courseId") UUID courseId,
                                               @RequestBody @Valid CourseRecordDto courseRecordDto) {
        logger.debug("PUT updateCourse courseRecordDto {}", courseRecordDto);
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update(courseRecordDto, courseService.findById(courseId).get()));
    }
}
