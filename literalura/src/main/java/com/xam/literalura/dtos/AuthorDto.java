package com.xam.literalura.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDto(
        @NotEmpty(message = "Name is required")
        String name,

        @NotNull(message = "Year of birth is required")
        @JsonAlias("birth_year")
        int yearOfBirth,

        @JsonAlias("death_year")
        int yearOfDeath
) {
}
