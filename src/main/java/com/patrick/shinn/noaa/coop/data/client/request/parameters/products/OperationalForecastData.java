package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

/**
 * Represents the various products the API offers.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum OperationalForecastData implements ApiDataProductParameter {

    // Operational Forecast
    /** Water level model guidance at 6-minute intervals based on NOS OFS models. Data available from 2020 to present. */
    OFS_WATER_LEVEL;

    public String getValue(){
        return this.name().toLowerCase();
    }
}
