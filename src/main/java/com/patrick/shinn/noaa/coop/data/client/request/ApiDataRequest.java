package com.patrick.shinn.noaa.coop.data.client.request;

import com.patrick.shinn.noaa.coop.data.client.request.parameters.*;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.products.ApiDataProductParameter;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.time.ApiTimeParameter;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.time.Date;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
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
    @Builder.Default
    private final Format format = Format.JSON;
    @NonNull
    private final Units units;
    @NonNull
    private final TimeZone timeZone;

    @Nullable
    @Builder.Default
    @Getter(AccessLevel.PACKAGE)
    private final Application application = Application.builder().name("noaa-coops-data-api-client-java").build();
    @Nullable
    private final Datum datum;
    @Nullable
    private final Interval interval;
    @Nullable
    private final VelocityType velocityType;
    @Nullable
    private final Bin bin;

    private final StringBuilder builder = new StringBuilder();

    /**
     * Builds an API request based on the supplied {@link ApiParameter}s.
     * @return Data API request arguments.
     * @since 1.0
     */
    public String getRequest(){
        validateParameters();
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
        getArgument(application);
        getArgument(datum);
        getArgument(interval);
        getArgument(velocityType);
        getArgument(bin);
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

    /** Validates that the required data product parameters/values are supplied */
    private void validateParameters(){
        // due to the nullability of several parameters, using Map.of is not an option, unfortunately.
        Map<Class<? extends ApiParameter>, ApiParameter> parameterMap = new HashMap<>();
        parameterMap.put(Date.class, date);
        parameterMap.put(Station.class, station);
        parameterMap.put(TimeZone.class, timeZone);
        parameterMap.put(Units.class, units);
        parameterMap.put(Format.class, format);
        // the remaining are nullable, if they are null they are considered to be not provided.
        if (application != null) parameterMap.put(Application.class, application);
        if (interval != null) parameterMap.put(Interval.class, interval);
        if (velocityType != null) parameterMap.put(VelocityType.class, velocityType);
        if (datum != null) parameterMap.put(Datum.class, datum);
        if (bin != null) parameterMap.put(Bin.class, bin);

        product.validateParameters(parameterMap);
    }
}
