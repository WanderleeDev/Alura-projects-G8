package com.xam.foro_hub.topic.infra.adapters.in.dtos;

import com.xam.foro_hub.topic.domain.enums.TopicStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TopicResponseDto(
        @Size(min = 36, max = 36)
        @NotBlank
        String id,

        @Size(min = 3, max = 200)
        @NotBlank
        String title,

        @Max(500)
        @NotBlank
        String message,

        LocalDate creationDate,

        TopicStatus status
) {
}
