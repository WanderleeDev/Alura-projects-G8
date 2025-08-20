package com.xam.foro_hub.topic.domain.ports.in;

import com.xam.foro_hub.topic.domain.model.TopicModel;
import com.xam.foro_hub.topic.domain.vo.Title;

import java.util.List;

public interface IFindTopicInteractor {

    public TopicModel findByTopicTitle(Title title);

    public List<TopicModel> findAllTopics();
}
