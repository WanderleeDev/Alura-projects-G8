package com.waderleedev.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrenciesApi {
    String result;

    String documentation;

    @SerializedName("terms_of_use")
    String termsOfUse;

    @SerializedName("supported_codes")
    List<CurrencyCode> supportedCurrencies;

    public CurrenciesApi() {}

    public List<CurrencyCode> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public record CurrencyCode(String code, String name) {}
}

