package com.waderleedev.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.waderleedev.dtos.CurrenciesApi;
import com.waderleedev.dtos.CurrencyApiResponse;
import com.waderleedev.dtos.CurrencyCodeDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class ApiRequestService implements IApiRequestService {
    private final HttpClient http;

    private final Gson gson;

    public ApiRequestService() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(
                CurrenciesApi.CurrencyCode.class,
                new CurrencyCodeDeserializer()
        ).create();
        this.http = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public List<CurrenciesApi.CurrencyCode> getCurrencies() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/931897fbe1e2af0e575a8cfe/codes"))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            CurrenciesApi currencyApiResponse = gson.fromJson(response.body() , CurrenciesApi.class);

            return currencyApiResponse.getSupportedCurrencies();
        } catch (IOException | InterruptedException e) {
            return List.of();
        }
    }

    public Optional<CurrencyApiResponse> getCurrencyData(String currency) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://v6.exchangerate-api.com/v6/931897fbe1e2af0e575a8cfe/latest/%s", currency)))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            CurrencyApiResponse currencyApiResponse = gson.fromJson(response.body() , CurrencyApiResponse.class);

            return Optional.of(currencyApiResponse);
        } catch (IOException | InterruptedException e) {
            return Optional.empty();
        }
    }
}
