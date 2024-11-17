package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

/**
 * Data from today’s date.
 * Note! Only available for preliminary water level data, meteorological data and predictions.
 * Valid options for the date parameter are:
 * <ul>
 *     <li>Today (24 hours starting at midnight)</li>
 *     <li>Latest (last data point available within the last 18 min)</li>
 *     <li>Recent (last 72 hours)</li>
 * </ul>
 * @since 1.0
 * @author Patrick Shinn
 */
public enum Date implements ApiTimeParameter {
    TODAY,
    LATEST,
    RECENT;

    @Override
    public String getValue() {
        return name().toLowerCase();
    }

    @Override
    public String getParameter() {
        return "date";
    }
}
