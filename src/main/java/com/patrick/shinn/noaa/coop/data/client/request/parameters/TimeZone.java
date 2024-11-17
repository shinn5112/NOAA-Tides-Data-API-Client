package com.patrick.shinn.noaa.coop.data.client.request.parameters;

/**
 * The time_zone of the data can be specified with the option parameter.
 * Note!Does not apply to products of datums or monthly_mean; daily_mean (Great Lakes) must use time_zone=lst
 *
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum TimeZone implements ApiParameter {
    /** Greenwich Mean Time */
    GMT,
    /** Local Standard Time, not corrected for Daylight Saving Time, local to the requested station. */
    LST,
    /** Local Standard Time, corrected for Daylight Saving Time when appropriate, local to the requested station. */
    LST_LDT;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }

    @Override
    public String getParameter() {
        return "time_zone";
    }
}