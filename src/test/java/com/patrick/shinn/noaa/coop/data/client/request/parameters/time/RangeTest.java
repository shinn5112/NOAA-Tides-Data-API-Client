package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @Test
    void testGetValue() {
        Range range = Range.builder()
                .hours(5)
                .build();
        assertEquals("5", range.getValue());
    }

    @Test
    void testGetParameter() {
        Range range = Range.builder()
                .hours(5)
                .build();
        assertEquals("range", range.getParameter());
    }

    @Test
    void testPositiveHours() {
        Range range = Range.builder()
                .hours(10)
                .build();
        assertEquals(10, range.hours);
    }

    @Test
    void testNegativeHours() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Range.builder().hours(-5).build());
        assertEquals("hours must be greater than 0.", thrown.getMessage());
    }

    @Test
    void testZeroHours() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Range.builder().hours(0).build());
        assertEquals("hours must be greater than 0.", thrown.getMessage());
    }

    @Test
    void testNonNullHours() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> Range.builder().build());
        assertNotNull(thrown.getMessage());
    }
}
