package com.ead.course.dtos.response;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SubscriptionRecordDto(@NotNull(message = "UserId is mandatory")
                                    UUID userId) {
}
