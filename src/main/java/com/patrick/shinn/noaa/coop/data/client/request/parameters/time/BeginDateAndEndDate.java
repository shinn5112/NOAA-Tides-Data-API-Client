package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import lombok.Builder;
import lombok.NonNull;

import java.util.Date;

/**
 * Specify the date/time range of retrieval with a beginning and ending date.
 * @since 1.0
 * @author Patrick Shinn
 */
@Builder
public class BeginDateAndEndDate extends TwoPartTime implements ApiTimeParameter {
    @NonNull
    private final Date beginDate;
    @NonNull
    private final Date endDate;

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
        return String.format("begin_date=%s&end_date=%s", formatDate(beginDate), formatDate(endDate));
    }
}
