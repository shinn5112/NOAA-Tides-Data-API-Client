package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {

    @Test
    void testGetValueHourly() {
        assertEquals("h", Interval.HOURLY.getValue());
    }

    @Test
    void testGetValueOneMinute() {
        assertEquals("1", Interval.ONE_MINUTE.getValue());
    }

    @Test
    void testGetValueFiveMinutes() {
        assertEquals("5", Interval.FIVE_MINUTES.getValue());
    }

    @Test
    void testGetValueSixMinutes() {
        assertEquals("6", Interval.SIX_MINUTES.getValue());
    }

    @Test
    void testGetValueTenMinutes() {
        assertEquals("10", Interval.TEN_MINUTES.getValue());
    }

    @Test
    void testGetValueFifteenMinutes() {
        assertEquals("15", Interval.FIFTEEN_MINUTES.getValue());
    }

    @Test
    void testGetValueThirtyMinutes() {
        assertEquals("30", Interval.THIRTY_MINUTES.getValue());
    }

    @Test
    void testGetValueSixtyMinutes() {
        assertEquals("60", Interval.SIXTY_MINUTES.getValue());
    }

    @Test
    void testGetValueHiLow() {
        assertEquals("hilo", Interval.HI_LOW.getValue());
    }

    @Test
    void testGetParameter() {
        for (Interval interval : Interval.values()) {
            assertEquals("interval", interval.getParameter());
        }
    }
}
