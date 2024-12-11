package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Tide/Water Level Data
 * Verified water level height data cannot be retrieved using the Interval parameter.
 * Each available interval for verified water level data is a separate data product and must be retrieved using the appropriate product type.
 * Tide/Water Level Predictions
 * Note! Harmonic tide prediction stations can provide tide predictions on any available interval.
 * Subordinate tide prediction stations can only provide tide predictions on a high / low interval.
 * Data Length Limitation: High/Low tide predictions are limited to 10 years. All other intervals are limited to 1 year.
 * @since 1.0
 * @author Patrick Shinn
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Interval implements ApiParameter {
    /** Hourly tide predictions for the station. */
    HOURLY("h"),
    ONE_MINUTE("1"),
    FIVE_MINUTES("5"),
    SIX_MINUTES("6"),
    TEN_MINUTES("10"),
    FIFTEEN_MINUTES("15"),
    THIRTY_MINUTES("30"),
    SIXTY_MINUTES("60"),
    /** Tide predictions for high tide and low tide times and heights. */
    HI_LOW("hilo"),
    /** max flood, slack water, and max ebb currents */
    MAX_SLACK("max_slack");

    private final String value;

    @Override
    public String getParameter() {
        return "interval";
    }
}
