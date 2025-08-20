package com.xam.foro_hub.course.infra.adapters.out;

import com.xam.foro_hub.common.infra.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Course extends BaseEntity {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must have between 3 and 50 characters")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Category is required")
    @Column(name = "category", nullable = false)
    private String category;
}