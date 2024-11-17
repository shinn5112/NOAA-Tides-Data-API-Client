package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EndDateAndRangeTest {

    EndDateAndRange target;

    @Test
    void requiredParameters(){
        assertThrows(NullPointerException.class, () -> target = EndDateAndRange.builder()
                .endDate(Date.from(Instant.now()))
                .build());
        assertThrows(NullPointerException.class, () -> target = EndDateAndRange.builder()
                .build());
        assertThrows(IllegalArgumentException.class, () -> target = EndDateAndRange.builder()
                .endDate(Date.from(Instant.now()))
                .hours(-5)
                .build());
        target = EndDateAndRange.builder()
                .endDate(java.util.Date.from(Instant.now()))
                .hours(12)
                .build();
    }

    @Test
    void getParameterFails(){
        Date expectedDate = Date.from(Instant.now());
        assertThrows(UnsupportedOperationException.class, () -> {
            target = EndDateAndRange.builder()
                    .hours(12)
                    .endDate(expectedDate)
                    .build();
            target.getParameter();
        });
    }

    @Test
    void getValueFails(){
        Date expectedDate = Date.from(Instant.now());
        assertThrows(UnsupportedOperationException.class, () -> {
            target = EndDateAndRange.builder()
                    .hours(12)
                    .endDate(expectedDate)
                    .build();
            target.getValue();
        });
    }

    @Test
    void getRequestArgument() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyddMM");
        java.util.Date expectedDate = Date.from(Instant.now());
        int expectedRange = 5;
        String expectedRequestArgument = String.format("end_date=%s&range=%s",
                format.format(expectedDate),
                expectedRange
        );
        target = EndDateAndRange.builder()
                .endDate(expectedDate)
                .hours(expectedRange)
                .build();
        assertEquals(expectedRequestArgument, target.getRequestArgument());
    }
}