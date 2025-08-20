package com.xam.foro_hub.topic.infra.adapters.out;

import com.xam.foro_hub.common.infra.BaseEntity;
import com.xam.foro_hub.course.infra.adapters.out.Course;
import com.xam.foro_hub.response.infra.adapters.out.Response;
import com.xam.foro_hub.user.infra.adapters.out.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Topic extends BaseEntity {
    
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    @Column(nullable = false, length = 200)
    String title;

    @NotBlank(message = "Message is required")
    @Column(columnDefinition = "TEXT", nullable = false)
    String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    TopicStatus status = TopicStatus.NOT_ANSWERED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    List<Response> responses = new ArrayList<>();

    public enum TopicStatus {
        NOT_ANSWERED,
        NOT_SOLVED,
        SOLVED,
        CLOSED
    }
}
