package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WaterDataTest {

    @Test
    void testGetValueWaterLevel() {
        assertEquals("water_level", WaterData.WATER_LEVEL.getValue());
    }

    @Test
    void testGetValueHourlyHeight() {
        assertEquals("hourly_height", WaterData.HOURLY_HEIGHT.getValue());
    }

    @Test
    void testGetValueHighLow() {
        assertEquals("high_low", WaterData.HIGH_LOW.getValue());
    }

    @Test
    void testGetValueDailyMean() {
        assertEquals("daily_mean", WaterData.DAILY_MEAN.getValue());
    }

    @Test
    void testGetValueMonthlyMean() {
        assertEquals("monthly_mean", WaterData.MONTHLY_MEAN.getValue());
    }

    @Test
    void testGetValueOneMinuteWaterLevel() {
        assertEquals("one_minute_water_level", WaterData.ONE_MINUTE_WATER_LEVEL.getValue());
    }

    @Test
    void testGetValuePredictions() {
        assertEquals("predictions", WaterData.PREDICTIONS.getValue());
    }

    @Test
    void testGetValueDatums() {
        assertEquals("datums", WaterData.DATUMS.getValue());
    }

    @Test
    void testGetValueAirGap() {
        assertEquals("air_gap", WaterData.AIR_GAP.getValue());
    }

    @Test
    void getParameter() {
        assertEquals("product", WaterData.WATER_LEVEL.getParameter());
    }
}

