package com.waderleedev.dtos;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyApiResponse {
    String result;

    String documentation;

    @SerializedName("terms_of_use")
    String termsOfUse;

    @SerializedName("time_last_update_unix")
    Long timeLastUpdateUnix;

    @SerializedName("time_last_update_utc")
    String timeLastUpdateUtc;

    @SerializedName("time_next_update_unix")
    Long timeNextUpdateUnix;

    @SerializedName("time_next_update_utc")
    String timeNextUpdateUtc;

    @SerializedName("base_code")
    String baseCode;

    @SerializedName("conversion_rates")
    Map<String, BigDecimal> conversionRates;

    public CurrencyApiResponse() {}

    public String getResult() { return result; }
    public String getDocumentation() { return documentation; }
    public String getTermsOfUse() { return termsOfUse; }
    public Long getTimeLastUpdateUnix() { return timeLastUpdateUnix; }
    public String getTimeLastUpdateUtc() { return timeLastUpdateUtc; }
    public Long getTimeNextUpdateUnix() { return timeNextUpdateUnix; }
    public String getTimeNextUpdateUtc() { return timeNextUpdateUtc; }
    public String getBaseCode() { return baseCode; }
    public Map<String, BigDecimal> getConversionRates() { return conversionRates; }

}
