package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

/**
 * Represents the various products the API offers.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum CurrentsData implements ApiDataProductParameter {

    // Currents Data
    /** Currents data for the station. Note! Default data interval is 6-minute interval data.Use with “interval=h” for hourly data>
     * There may be differences in bin depths across the deployments as sensor depth and on rare occasions bin size could change when
     * a sensor is re-deployed. */
    CURRENTS,
    /** Currents prediction data for the stations. Note! See Interval for options available and data length limitations. */
    CURRENTS_PREDICTIONS;

    public String getValue(){
        return this.name().toLowerCase();
    }
}
