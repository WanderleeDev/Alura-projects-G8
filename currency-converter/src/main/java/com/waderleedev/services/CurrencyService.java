package com.waderleedev.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyService implements ICurrencyService {
    private final IApiRequestService apiRequestService;

    public CurrencyService(IApiRequestService apiRequestService) {
        this.apiRequestService = apiRequestService;
    }

    @Override
    public void viewCurrencies() {
        var currencies = this.apiRequestService.getCurrencies();

        if (currencies.isEmpty()) {
            System.out.println("Currencies not available");
            return;
        }

        StringBuilder currenciesFormat = new StringBuilder("Available currencies:\n");

        for (int i = 0; i < currencies.size(); i++) {
            var currency = currencies.get(i);
            currenciesFormat.append(
                    String.format("%d.  %s - %s%n", i + 1, currency.code(), currency.name())
            );
        }

        System.out.println(currenciesFormat);
    }

    public void calculateExchange(
            String sourceCurrency,
            String targetCurrency,
            BigDecimal amount
    ) {
        if (sourceCurrency.equals(targetCurrency) || amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("You cannot convert the same currency or an invalid amount");
            return;
        }

        var rates = this.apiRequestService.getCurrencyData(sourceCurrency);

        if (rates.isEmpty()) {
            System.out.println("Currency not available");
            return;
        }

        BigDecimal rate = rates.get().getConversionRates().get(targetCurrency);

        if (rate == null) {
            System.out.println("Currency rate not available");
            return;
        }

        BigDecimal convertedAmount = rate
                .multiply(amount)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.printf("\n%s %s to %s is %s %s\n",
                amount,
                sourceCurrency,
                targetCurrency,
                convertedAmount,
                targetCurrency
        );
    }
}
