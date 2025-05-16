package com.ead.course.controllers;

import com.ead.course.dtos.response.SubscriptionRecordDto;
import com.ead.course.model.CourseModel;
import com.ead.course.model.UserModel;
import com.ead.course.service.CourseService;
import com.ead.course.service.UserService;
import com.ead.course.specifications.SpecificationTemplate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    final UserService userService;

    public CourseUserController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/courses/{courseId}/users")
    public ResponseEntity<Page<UserModel>> getAllUsersByCourse(@PathVariable(value = "courseId") UUID courseId,
                                                               @PageableDefault(sort = "userId", direction = Sort.Direction.ASC) Pageable pageable,
                                                               SpecificationTemplate.UserSpec spec) {

        courseService.findById(courseId);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(userService.findAll(SpecificationTemplate.userCourseId(courseId).and(spec), pageable));
    }

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<Object> saveSubscriptionUserInCourse(@PathVariable(value = "courseId") UUID courseId,
                                                               @RequestBody @Valid SubscriptionRecordDto subscriptionRecordDto) {

        Optional<CourseModel> courseModelOptional = courseService.findById(courseId);
        // verifications with state transfer
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
