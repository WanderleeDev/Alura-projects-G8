package com.xam.foro_hub.topic.domain.ports.out;

import com.xam.foro_hub.topic.domain.model.TopicModel;
import com.xam.foro_hub.topic.domain.vo.Title;

import java.util.List;

public interface ITopicRepository {

    TopicModel save(TopicModel topic);

    TopicModel update(TopicModel topic);

    TopicModel findByTitle(Title title);

    List<TopicModel> findAllTopics();
}
