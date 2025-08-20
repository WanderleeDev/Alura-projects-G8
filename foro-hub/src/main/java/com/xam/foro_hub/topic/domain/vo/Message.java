package com.xam.foro_hub.topic.domain.vo;


import com.xam.foro_hub.topic.domain.exceptions.InvalidTopicException;

public record Message(String value) {
    private static final int MAX_LENGTH = 500;

    public Message {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidTopicException("Message can't be empty");
        }

        if (value.length() > MAX_LENGTH) {
            throw new InvalidTopicException("The message cannot have more than " + MAX_LENGTH + " characters");
        }
    }
}
