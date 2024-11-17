package com.patrick.shinn.noaa.coop.data.client.request.parameters;

/** This only applies to Current Predictions at Harmonic Stations. */
public enum VelocityType implements ApiParameter{
    /** Return results for speed and direction -the 2-dimensional speed and direction, may not match flood/ebb directions
     Note!only supports current prediction intervals of 1, 6, 10, 30, 60; does not apply to max_slack predictions. */
    SPEED_DIR,
    /** Return results for velocity major, mean flood direction and mean ebb direction.
     If not included in the API query, the default is automatically used */
    DEFAULT;

    @Override
    public String getValue() {
        return this.name().toLowerCase();
    }

    @Override
    public String getParameter() {
        return "Vel_type";
    }
}
