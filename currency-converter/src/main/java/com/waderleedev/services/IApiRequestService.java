package com.waderleedev.services;

import com.waderleedev.dtos.CurrenciesApi;
import com.waderleedev.dtos.CurrencyApiResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IApiRequestService {
    List<CurrenciesApi.CurrencyCode> getCurrencies();

    Optional<CurrencyApiResponse> getCurrencyData(String currency);
}
