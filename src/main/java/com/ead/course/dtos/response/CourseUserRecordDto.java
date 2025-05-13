package com.ead.course.dtos.response;

import java.util.UUID;

public record CourseUserRecordDto(UUID courseId,
                                  UUID userId) {
}
