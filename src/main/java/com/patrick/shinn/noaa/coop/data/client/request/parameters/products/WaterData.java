package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

/**
 * Represents the various products the API offers.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum WaterData implements ApiDataProductParameter {
    // Tides/Water Level Data
    /** Preliminary or verified 6-minute interval water levels, depending on data availability. */
    WATER_LEVEL,
    /** Verified hourly height water level data for the station. */
    HOURLY_HEIGHT,
    /** Verified high tide / low tide water level data for the station. */
    HIGH_LOW,
    /** Verified daily mean water level data for the station.
     Note!Great Lakes stations only. Only available with “time_zone=LST” */
    DAILY_MEAN,
    /** Verified monthly mean water level data for the station. */
    MONTHLY_MEAN,
    /** Preliminary 1-minute interval water level data for the station. */
    ONE_MINUTE_WATER_LEVEL,
    /** Water level / tide prediction data for the station.
     Note!See Interval for available data interval options and data length limitations. */
    PREDICTIONS,
    /** Observed tidal datum values at the station for the present National Tidal Datum Epoch (NTDE).*/
    DATUMS,
    /** Air Gap (distance between a bridge and the water's surface) at the station. */
    AIR_GAP;

    public String getValue(){
        return this.name().toLowerCase();
    }
}
