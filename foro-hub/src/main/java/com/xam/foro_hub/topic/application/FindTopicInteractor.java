package com.xam.foro_hub.topic.application;

import com.xam.foro_hub.topic.domain.model.TopicModel;
import com.xam.foro_hub.topic.domain.ports.in.IFindTopicInteractor;
import com.xam.foro_hub.topic.domain.ports.out.ITopicRepository;
import com.xam.foro_hub.topic.domain.vo.Title;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FindTopicInteractor implements IFindTopicInteractor {

    private final ITopicRepository repository;

    @Override
    public TopicModel findByTopicTitle(Title title) {
        repository.findByTitle(title);
        return null;
    }

    @Override
    public List<TopicModel> findAllTopics() {
        return List.of();
    }
}
