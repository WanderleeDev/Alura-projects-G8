package com.xam.foro_hub.topic.domain.vo;

import com.xam.foro_hub.topic.domain.exceptions.InvalidTopicException;

public record Title(String value) {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 200;

    public Title {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidTopicException("El título no puede estar vacío");
        }
        if (value.length() < MIN_LENGTH) {
            throw new InvalidTopicException("El título debe tener al menos " + MIN_LENGTH + " caracteres");
        }
        if (value.length() > MAX_LENGTH) {
            throw new InvalidTopicException("El título no puede tener más de " + MAX_LENGTH + " caracteres");
        }
    }
}
