package com.ead.course.dtos.response;

import jakarta.validation.constraints.NotBlank;

public record LessonRecordDto(@NotBlank(message = "Title is mandatory")
                              String title,

                              @NotBlank(message = "description is mandatory")
                              String description,

                              @NotBlank(message = "videoUrl is mandatory")
                              String videoUrl) {
}
