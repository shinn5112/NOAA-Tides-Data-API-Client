package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import com.patrick.shinn.noaa.coop.data.client.exception.ApiDataProductException;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.ApiParameter;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.Datum;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.Interval;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.TimeZone;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WaterDataTest {

    @Test
    void testGetValueWaterLevel() {
        assertEquals("water_level", WaterData.WATER_LEVEL.getValue());
    }

    @Test
    void testValidateParametersWaterLevel() {
        // Arrange
        WaterData waterData = WaterData.WATER_LEVEL;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueHourlyHeight() {
        assertEquals("hourly_height", WaterData.HOURLY_HEIGHT.getValue());
    }

    @Test
    void testValidateParametersHourlyHeight() {
        // Arrange
        WaterData waterData = WaterData.HOURLY_HEIGHT;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueHighLow() {
        assertEquals("high_low", WaterData.HIGH_LOW.getValue());
    }

    @Test
    void testValidateParametersHighLow() {
        // Arrange
        WaterData waterData = WaterData.HIGH_LOW;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueDailyMean() {
        assertEquals("daily_mean", WaterData.DAILY_MEAN.getValue());
    }

    @Test
    void testValidateParametersDailyMean() {
        // Arrange
        WaterData waterData = WaterData.DAILY_MEAN;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no missing timezone
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));
        actualParameters.put(TimeZone.class, TimeZone.GMT);
        // invalid timezone
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));
        actualParameters.put(TimeZone.class, TimeZone.LST);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueMonthlyMean() {
        assertEquals("monthly_mean", WaterData.MONTHLY_MEAN.getValue());
    }

    @Test
    void testValidateParametersMonthlyMean() {
        // Arrange
        WaterData waterData = WaterData.MONTHLY_MEAN;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueOneMinuteWaterLevel() {
        assertEquals("one_minute_water_level", WaterData.ONE_MINUTE_WATER_LEVEL.getValue());
    }

    @Test
    void testValidateParametersOneMinute() {
        // Arrange
        WaterData waterData = WaterData.ONE_MINUTE_WATER_LEVEL;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValuePredictions() {
        assertEquals("predictions", WaterData.PREDICTIONS.getValue());
    }

    @Test
    void testValidateParametersPredictions() {
        // Arrange
        WaterData waterData = WaterData.PREDICTIONS;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue, also asserts that interval is not required.
        waterData.validateParameters(actualParameters);

        actualParameters.put(Interval.class, Interval.MAX_SLACK);
        // Invalid interval
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));
    }

    @Test
    void testGetValueDatums() {
        assertEquals("datums", WaterData.DATUMS.getValue());
    }

    @Test
    void testValidateParametersDatums() {
        // Arrange
        WaterData waterData = WaterData.DATUMS;
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = new HashMap<>();

        // Datum required
        assertThrows(ApiDataProductException.class, () -> waterData.validateParameters(actualParameters));

        // any Datum
        actualParameters.put(Datum.class, Datum.CRD);
        // no issue
        waterData.validateParameters(actualParameters);
    }

    @Test
    void testGetValueAirGap() {
        assertEquals("air_gap", WaterData.AIR_GAP.getValue());
    }

    @Test
    void testValidateParametersAirGap() throws ApiDataProductException {
        // Arrange
        WaterData waterData = WaterData.AIR_GAP; // No required parameters
        Map<Class<? extends ApiParameter>, ApiParameter> actualParameters = Collections.emptyMap();

        // Act
        waterData.validateParameters(actualParameters);

        // Assert (no exception thrown)
    }

    @Test
    void getParameter() {
        assertEquals("product", WaterData.WATER_LEVEL.getParameter());
    }

}


