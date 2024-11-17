package com.patrick.shinn.noaa.coop.data.client.request.parameters;


/**
 * Represents the various datum parameter values.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum Datum implements ApiParameter {
    /** Columbia River Datum. Note!Only available for certain stations on the Columbia River, Washington/Oregon */
    CRD,
    /** International Great Lakes Datum Note! Only available for Great Lakes stations. */
    IGLD,
    /** Great Lakes Low Water Datum (Nautical Chart Datum for the Great Lakes).
     Note! Only available for Great Lakes Stations */
    LWD,
    /** Mean Higher High Water */
    MHHW,
    /** Mean High Water */
    MHW,
    /** Mean Tide Level */
    MTL,
    /** Mean Sea Level */
    MSL,
    /** Mean Low Water */
    MLW,
    /** Mean Lower Low Water (Nautical Chart Datum for all U.S. coastal waters)
     Note! Subordinate tide prediction stations must use “datum=MLLW” */
    MLLW,
    /** North American Vertical Datum Note! This datum is not available for all stations. */
    NAVD,
    /** Station Datum - original reference that all data is collected to, uniquely defined for each station. */
    STND;

    /**
     * Gets the value to be used with the API.
     * @return the name of this enum.
     */
    @Override
    public String getValue(){
        return this.name();
    }

    @Override
    public String getParameter() {
        return "datum";
    }
}
