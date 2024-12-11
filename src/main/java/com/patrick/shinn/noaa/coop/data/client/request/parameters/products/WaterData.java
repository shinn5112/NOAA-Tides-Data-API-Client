package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import com.patrick.shinn.noaa.coop.data.client.exception.ApiDataProductException;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.ApiParameter;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.Datum;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.Interval;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.TimeZone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Represents the various tide/water products the API offers.
 * @since 1.0.0
 * @author Patrick Shinn
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum WaterData implements ApiDataProductParameter {
    // Tides/Water Level Data
    /** Preliminary or verified 6-minute interval water levels, depending on data availability. */
    WATER_LEVEL(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Verified hourly height water level data for the station. */
    HOURLY_HEIGHT(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Verified high tide / low tide water level data for the station. */
    HIGH_LOW(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Verified daily mean water level data for the station.
     Note!Great Lakes stations only. Only available with “time_zone=LST” */
    DAILY_MEAN(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false),
            new WaterDataParameter(TimeZone.class, List.of(TimeZone.LST), false)
    )),
    /** Verified monthly mean water level data for the station. */
    MONTHLY_MEAN(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Preliminary 1-minute interval water level data for the station. */
    ONE_MINUTE_WATER_LEVEL(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Water level / tide prediction data for the station.
     Note!See Interval for available data interval options and data length limitations. */
    PREDICTIONS(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false),
            new WaterDataParameter(Interval.class,
                    List.of(
                        Interval.HOURLY,
                        Interval.ONE_MINUTE,
                        Interval.FIVE_MINUTES,
                        Interval.SIX_MINUTES,
                        Interval.FIFTEEN_MINUTES,
                        Interval.TEN_MINUTES,
                        Interval.FIFTEEN_MINUTES,
                        Interval.THIRTY_MINUTES,
                        Interval.SIXTY_MINUTES,
                        Interval.HI_LOW),
                    true)
            )
    ),
    /** Observed tidal datum values at the station for the present National Tidal Datum Epoch (NTDE).*/
    DATUMS(List.of(
            new WaterDataParameter(Datum.class, Collections.emptyList(), false)
    )),
    /** Air Gap (distance between a bridge and the water's surface) at the station. */
    AIR_GAP(Collections.emptyList()); // no required parameters

    private final List<WaterDataParameter> requiredParameters;
    private static final String INVALID_VALUE_MESSAGE = "Invalid value \"%s\" for parameter \"%s\". Expected values are \"%s\"";
    private static final String MISSING_PARAMETER_MESSAGE = "Missing expected parameter \"%s\"";

    @Override
    public void validateParameters(Map<Class<? extends ApiParameter>, ApiParameter> actualParameters) throws ApiDataProductException {
        requiredParameters.forEach(waterDataParameter -> {
            if (actualParameters.containsKey(waterDataParameter.getParameter()) || waterDataParameter.isOptional) {
                if ( // ensure key is not optional and missing
                    actualParameters.containsKey(waterDataParameter.getParameter())
                    // any value not allowed, if the values list is empty we accept any value
                    && waterDataParameter.values.isEmpty()
                    // parameter value allowed
                    && !waterDataParameter.values.contains(actualParameters.get(waterDataParameter.getParameter()))
                ) { // the parameter is passed with an invalid value
                    ApiDataProductException ex = new ApiDataProductException(String.format(INVALID_VALUE_MESSAGE,
                            actualParameters.get(waterDataParameter.getParameter()),
                            waterDataParameter.getParameter().getSimpleName(),
                            waterDataParameter.getValues()));
                    log.error(ex.getMessage());
                    throw ex;
                }
            } else { // an API parameter is missing
                ApiDataProductException ex = new ApiDataProductException(
                        String.format(MISSING_PARAMETER_MESSAGE, waterDataParameter.getParameter().getSimpleName()));
                log.error(ex.getMessage());
                throw ex;
            }
        });
    }

    @Override
    public String getValue(){
        return this.name().toLowerCase();
    }

    /** Simple wrapper for parameter data. */
    @AllArgsConstructor
    @Getter
    private static class WaterDataParameter {
        private Class<? extends ApiParameter> parameter;
        private List<ApiParameter> values;
        private boolean isOptional;
    }
}
