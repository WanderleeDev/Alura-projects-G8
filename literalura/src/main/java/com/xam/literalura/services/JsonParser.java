package com.xam.literalura.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonParser {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T parse(String json, Class<T> classModel) {
        try {
            return mapper.readValue(json, classModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
