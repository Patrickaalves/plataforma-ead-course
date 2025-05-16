package com.ead.course.controllers;

import com.ead.course.dtos.response.SubscriptionRecordDto;
import com.ead.course.model.CourseModel;
import com.ead.course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CourseUserController {

    final CourseService courseService;

    public CourseUserController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}/users")
    public ResponseEntity<Object> getAllUsersByCourse(@PathVariable(value = "courseId") UUID courseId,
                                                                   @PageableDefault(sort = "userId", direction = Sort.Direction.ASC) Pageable pageable) {
        courseService.findById(courseId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<Object> saveSubscriptionUserInCourse(@PathVariable(value = "courseId") UUID courseId,
                                                               @RequestBody @Valid SubscriptionRecordDto subscriptionRecordDto) {

        Optional<CourseModel> courseModelOptional = courseService.findById(courseId);
        // verifications with state transfer
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
