package com.xam.foro_hub.topic.domain.ports.in;

import com.xam.foro_hub.topic.domain.model.TopicModel;

public interface ICreateTopic {
    public TopicModel execute(TopicModel topic);
}
