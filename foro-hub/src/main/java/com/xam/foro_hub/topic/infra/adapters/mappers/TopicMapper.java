package com.xam.foro_hub.topic.infra.adapters.mappers;

import com.xam.foro_hub.common.domain.vo.Identifier;
import com.xam.foro_hub.topic.domain.model.TopicModel;
import com.xam.foro_hub.topic.domain.vo.Message;
import com.xam.foro_hub.topic.domain.vo.Title;
import com.xam.foro_hub.topic.infra.adapters.in.dtos.TopicResponseDto;
import com.xam.foro_hub.topic.infra.adapters.out.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "mapId")
    @Mapping(target = "title", source = "title", qualifiedByName = "mapTitle")
    @Mapping(target = "message", source = "message", qualifiedByName = "mapMessage")
    TopicResponseDto toResponseDto (TopicModel model);

    @Mapping(target = "id", source = "id", qualifiedByName = "mapId")
    @Mapping(target = "title", source = "title", qualifiedByName = "mapTitleVo")
    @Mapping(target = "message", source = "message", qualifiedByName = "mapMessageVo")
    TopicModel toModel(Topic topic);

    @Named("mapId")
    default String mapId(Identifier id) {
        return id.value();
    }

    @Named("mapIdVo")
    default Identifier mapIdVo(String id) {
      return Identifier.fromString(id);
    }

    @Named("mapTitleVo")
    default Title mapTitleVo(String title) {
        return new Title(title);
    }

    @Named("mapMessageVo")
    default Message mapMessageVo(String message) {
        return new Message(message);
    }

    @Named("mapTitle")
    default String mapTitle(Title title) {
        return title.value();
    }

    @Named("mapMessage")
    default String mapMessage(Message message) {
        return message.value();
    }
}
