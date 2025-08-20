package com.xam.foro_hub.common.domain.vo;

import com.xam.foro_hub.common.domain.exceptions.InvalidIdentifierException;

import java.util.Objects;
import java.util.UUID;

public record Identifier(String value) {
    
    public Identifier {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidIdentifierException("ID cannot be empty");
        }

        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdentifierException("Invalid ID: " + value);
        }
    }
    
    public Identifier(UUID uuid) {
        this(Objects.requireNonNull(uuid, "El UUID no puede ser nulo").toString());
    }

    public static Identifier unique() {
        return new Identifier(UUID.randomUUID());
    }
    
    public static Identifier fromString(String value) {
        return new Identifier(value);
    }
    
    public static Identifier fromUuid(UUID uuid) {
        return new Identifier(uuid);
    }
}
