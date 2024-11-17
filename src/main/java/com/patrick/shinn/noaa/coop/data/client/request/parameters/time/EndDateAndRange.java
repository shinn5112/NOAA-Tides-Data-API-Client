package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import lombok.Builder;
import lombok.NonNull;

import java.util.Date;

/**
 * Specify the date/time range of retrieval with an end date and the number of hours before the end of that day.
 * @since 1.0
 * @author Patrick Shinn
 */
@Builder(builderClassName = "Builder")
public class EndDateAndRange extends TwoPartTime implements ApiTimeParameter {
    @NonNull
    private final Date endDate;
    @NonNull
    private final Integer hours;

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getParameter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getRequestArgument() {
        return String.format("end_date=%s&range=%s", formatDate(endDate), hours);
    }

    public static class Builder {
        public EndDateAndRange build(){
            if( hours <= 0){
                throw new IllegalArgumentException("hours must be greater than zero.");
            }
            return new EndDateAndRange(endDate, hours);
        }
    }
}
