package com.xam.foro_hub.topic.domain.model;

import com.xam.foro_hub.common.domain.vo.Identifier;
import com.xam.foro_hub.topic.domain.enums.TopicStatus;
import com.xam.foro_hub.topic.domain.vo.Message;
import com.xam.foro_hub.topic.domain.vo.Title;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicModel {
    Identifier id;
    Title title;
    Message message;
    TopicStatus status;
    Identifier authorId;
    Identifier courseId;
    List<Identifier> responseIds;
    LocalDate creationDate;
}
