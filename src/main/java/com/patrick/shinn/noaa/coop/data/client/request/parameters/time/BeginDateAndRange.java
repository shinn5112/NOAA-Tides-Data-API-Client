package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import lombok.Builder;
import lombok.NonNull;

import java.util.Date;

/**
 * Specify a beginning date and a number of hours to retrieve data starting from that date.
 * @since 1.0
 * @author Patrick Shinn
 */
@Builder(builderClassName = "Builder")
public class BeginDateAndRange extends TwoPartTime implements ApiTimeParameter {
    @NonNull
    private final Date beginDate;
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
        return String.format("begin_date=%s&range=%s", formatDate(beginDate), hours);
    }

    public static class Builder {
        public BeginDateAndRange build(){
            if( hours <= 0){
                throw new IllegalArgumentException("hours must be greater than zero.");
            }
            return new BeginDateAndRange(beginDate, hours);
        }
    }
}
