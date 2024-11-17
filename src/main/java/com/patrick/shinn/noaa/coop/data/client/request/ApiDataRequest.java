package com.patrick.shinn.noaa.coop.data.client.request;

import com.patrick.shinn.noaa.coop.data.client.request.parameters.*;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.products.ApiDataProductParameter;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.time.ApiTimeParameter;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * API data request. Supplied as a builder.
 * @since 1.0
 * @author Patrick Shinn
 */
@Builder
public class ApiDataRequest {
    @NonNull
    private final ApiTimeParameter date;
    @NonNull
    private final Station station;
    @NonNull
    private final ApiDataProductParameter product;
    @NonNull
    @Getter
    private final Format format;
    @NonNull
    private final Units units;
    @NonNull
    private final TimeZone timeZone;

    @Nullable
    private final Datum datum;
    @Nullable
    private final Interval interval;
    @Nullable
    private final VelocityType velocityType;
    @Nullable
    private final Bin bin;
    @Nullable
    private final Application application;

    private final StringBuilder builder = new StringBuilder();

    /**
     * Builds an API request based on the supplied {@link ApiParameter}s.
     * @return Data API request arguments.
     * @since 1.0
     */
    public String getRequest(){
        // These fields must be non-null and are always required.
        builder.append(date.getRequestArgument())
                .append("&")
                .append(station.getRequestArgument())
                .append("&")
                .append(product.getRequestArgument())
                .append("&")
                .append(timeZone.getRequestArgument())
                .append("&")
                .append(units.getRequestArgument())
                .append("&")
                .append(format.getRequestArgument());
        // the rest of these are optional based on what is being called.
        getArgument(datum);
        getArgument(interval);
        getArgument(velocityType);
        getArgument(bin);
        getArgument(application);
        return builder.toString();
    }

    private void getArgument(ApiParameter parameter){
        Optional.ofNullable(parameter).ifPresent(
                parameter1 -> {
                    builder.append("&");
                    builder.append(parameter1.getRequestArgument());
                }
        );
    }
}
