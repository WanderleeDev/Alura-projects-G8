package com.waderleedev.services;

import java.math.BigDecimal;

public interface ICurrencyService {
    void viewCurrencies();

    void calculateExchange(
            String sourceCurrency,
            String targetCurrency,
            BigDecimal amount
    );

}
