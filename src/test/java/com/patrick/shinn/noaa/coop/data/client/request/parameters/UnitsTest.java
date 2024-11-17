package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitsTest {

    @Test
    void testGetValueMetric() {
        assertEquals("metric", Units.METRIC.getValue());
    }

    @Test
    void testGetValueEnglish() {
        assertEquals("english", Units.ENGLISH.getValue());
    }

    @Test
    void testGetParameter() {
        for (Units units : Units.values()) {
            assertEquals("units", units.getParameter());
        }
    }
}
