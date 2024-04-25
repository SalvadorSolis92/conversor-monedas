package model;

import java.util.Map;

public record ResponseExchangeRateAll(
        String result,
        String documentation,
        String terms_of_use,
        Long time_last_update_unix,
        String time_last_update_utc,
        Long time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        Map<String, Double> conversion_rates
){ }