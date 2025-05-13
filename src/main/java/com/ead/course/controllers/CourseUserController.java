package com.ead.course.controllers;

import com.ead.course.clients.AuthUserClient;
import com.ead.course.dtos.response.SubscriptionRecordDto;
import com.ead.course.dtos.request.UserRecordDto;
import com.ead.course.enums.UserStatus;
import com.ead.course.model.CourseModel;
import com.ead.course.model.CourseUserModel;
import com.ead.course.service.CourseService;
import com.ead.course.service.CourseUserService;
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

    final AuthUserClient authUserClient;
    final CourseService courseService;
    final CourseUserService courseUserService;

    public CourseUserController(AuthUserClient authUserClient, CourseService courseService, CourseUserService courseUserService) {
        this.authUserClient = authUserClient;
        this.courseService = courseService;
        this.courseUserService = courseUserService;
    }

    @GetMapping("/courses/{courseId}/users")
    public ResponseEntity<Page<UserRecordDto>> getAllUsersByCourse(@PathVariable(value = "courseId") UUID userId,
                                                                   @PageableDefault(sort = "userId", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(authUserClient.getAllUsersByCourse(userId, pageable));
    }

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<Object> saveSubscriptionUserInCourse(@PathVariable(value = "courseId") UUID courseId,
                                                               @RequestBody @Valid SubscriptionRecordDto subscriptionRecordDto) {

        Optional<CourseModel> courseModelOptional = courseService.findById(courseId);
        if (courseUserService.existByCourseAndUserId(courseModelOptional.get(), subscriptionRecordDto.userId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Subscription already exists");
        }

        ResponseEntity<UserRecordDto> responseUser = authUserClient.getOneUserById(subscriptionRecordDto.userId());

        if (responseUser.getBody().userStatus().equals(UserStatus.BLOCKED)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: User is blocked.");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(courseUserService.saveAndSendSubscriptionUserInCourse(courseModelOptional.get().convertToCourseUserModel(subscriptionRecordDto.userId())));
    }
}
