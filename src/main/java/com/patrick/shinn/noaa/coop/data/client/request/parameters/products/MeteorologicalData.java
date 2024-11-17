package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

/**
 * Represents the various products the API offers.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum MeteorologicalData implements ApiDataProductParameter {
    // Meteorological Data
    /** Air temperature as measured at the station. */
    AIR_TEMPERATURE,
    /** Water temperature as measured at the station. */
    WATER_TEMPERATURE,
    /** Wind speed, direction, and gusts as measured at the station. */
    WIND,
    /** Barometric pressure as measured at the station. */
    AIR_PRESSURE,
    /** The water's conductivity as measured at the station. */
    CONDUCTIVITY,
    /** Visibility (atmospheric clarity) as measured at the station.
     (Units of Nautical Miles or Kilometers.) */
    VISIBILITY,
    /** Relative humidity as measured at the station. */
    HUMIDITY,
    /** Salinity and specific gravity data for the station. */
    SALINITY;

    public String getValue(){
        return this.name().toLowerCase();
    }
}
