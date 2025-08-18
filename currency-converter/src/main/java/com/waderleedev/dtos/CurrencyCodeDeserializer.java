package com.waderleedev.dtos;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CurrencyCodeDeserializer implements JsonDeserializer<CurrenciesApi.CurrencyCode> {
    @Override
    public CurrenciesApi.CurrencyCode deserialize(
            JsonElement json, Type type, JsonDeserializationContext ctx
    ) throws JsonParseException {
        JsonArray arr = json.getAsJsonArray();

        if (arr.size() != 2) {
            throw new JsonParseException("Not a valid currency code");
        }

        return new CurrenciesApi.CurrencyCode(
                arr.get(0).getAsString(),
                arr.get(1).getAsString()
        );
    }
}
