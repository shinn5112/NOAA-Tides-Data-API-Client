package com.patrick.shinn.noaa.coop.data.client.request.parameters;

/**
 * What units returned results should be described in.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public enum Units implements ApiParameter{
    /** 	Metric units (Celsius, meters, cm/s appropriate for the data)
     Note!Visibility data is kilometers (km), Currents data is in cm/s. */
    METRIC,
    /** 	English units (Fahrenheit, feet, knots appropriate for the data)
     Note!Visibility data is Nautical Miles (nm), Currents data is in knots. */
    ENGLISH;

    @Override
    public String getValue(){
        return this.name().toLowerCase();
    }

    @Override
    public String getParameter() {
        return "units";
    }
}
