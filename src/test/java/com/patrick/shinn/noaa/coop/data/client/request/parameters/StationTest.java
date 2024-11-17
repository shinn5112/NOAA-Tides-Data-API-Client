package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StationTest {

    @Test
    void testGetValue() {
        Station station = Station.builder()
                .stationId("12345")
                .build();
        assertEquals("12345", station.getValue());
    }

    @Test
    void testGetParameter() {
        Station station = Station.builder()
                .stationId("12345")
                .build();
        assertEquals("station", station.getParameter());
    }

    @Test
    void testStationIdNonNullAndNonEmpty() {
        Station station = Station.builder()
                .stationId("ABCDE")
                .build();
        assertEquals("ABCDE", station.getValue());
    }

    @Test
    void testStationIdNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Station.builder().stationId(null).build());
        assertEquals("stationId must have a non-null, non-empty value.", thrown.getMessage());
    }

    @Test
    void testStationIdEmpty() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Station.builder().stationId("").build());
        assertEquals("stationId must have a non-null, non-empty value.", thrown.getMessage());
    }

    @Test
    void testStationIdBlank() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Station.builder().stationId("    ").build());
        assertEquals("stationId must have a non-null, non-empty value.", thrown.getMessage());
    }
}
