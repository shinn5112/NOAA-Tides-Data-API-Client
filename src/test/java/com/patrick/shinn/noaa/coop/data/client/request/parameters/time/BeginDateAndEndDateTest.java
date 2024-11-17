package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class BeginDateAndEndDateTest {

    BeginDateAndEndDate target;

    @Test
    void DatesRequired(){
        assertThrows(NullPointerException.class, () -> target = BeginDateAndEndDate.builder()
                .build());
        assertThrows(NullPointerException.class, () -> target = BeginDateAndEndDate.builder()
                .beginDate(Date.from(Instant.now()))
                .build());
        assertThrows(NullPointerException.class, () -> target = BeginDateAndEndDate.builder()
                .endDate(Date.from(Instant.now()))
                .build());
        target = BeginDateAndEndDate.builder()
                .beginDate(Date.from(Instant.now()))
                .endDate(Date.from(Instant.now()))
                .build();
    }

    @Test
    void getParameterFails(){
        Date expectedDate = Date.from(Instant.now());
        assertThrows(UnsupportedOperationException.class, () -> {
            target = BeginDateAndEndDate.builder()
                    .beginDate(expectedDate)
                    .endDate(expectedDate)
                    .build();
            target.getParameter();
        });
    }

    @Test
    void getValueFails(){
        Date expectedDate = Date.from(Instant.now());
        assertThrows(UnsupportedOperationException.class, () -> {
            target = BeginDateAndEndDate.builder()
                    .beginDate(expectedDate)
                    .endDate(expectedDate)
                    .build();
            target.getValue();
        });
    }

    @Test
    void getRequestArgument() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyddMM");
        Date expectedDate = Date.from(Instant.now());
        String expectedRequestArgument = String.format("begin_date=%s&end_date=%s",
                format.format(expectedDate),
                format.format(expectedDate)
        );
        target = BeginDateAndEndDate.builder()
                .beginDate(expectedDate)
                .endDate(expectedDate)
                .build();
        assertEquals(expectedRequestArgument, target.getRequestArgument());
    }
}