package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeZoneTest {

    @Test
    void testGetValueGMT() {
        assertEquals("gmt", TimeZone.GMT.getValue());
    }

    @Test
    void testGetValueLST() {
        assertEquals("lst", TimeZone.LST.getValue());
    }

    @Test
    void testGetValueLST_LDT() {
        assertEquals("lst_ldt", TimeZone.LST_LDT.getValue());
    }

    @Test
    void testGetParameter() {
        for (TimeZone timeZone : TimeZone.values()) {
            assertEquals("time_zone", timeZone.getParameter());
        }
    }
}
