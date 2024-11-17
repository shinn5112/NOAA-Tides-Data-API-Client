package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import lombok.Builder;
import lombok.NonNull;

/**
 * Specify a number of hours back from now and retrieve data for that period.
 * @since 1.0
 * @author Patrick Shinn
 */
@Builder(builderClassName = "Builder")
public class Range implements ApiTimeParameter {
    @NonNull
    Integer hours;

    @Override
    public String getValue() {
        return String.valueOf(hours);
    }

    @Override
    public String getParameter() {
        return "range";
    }

    public static class Builder{
        public Range build(){
            if (hours <= 0){
                throw new IllegalArgumentException("hours must be greater than 0.");
            }
            return new Range(hours);
        }
    }
}
