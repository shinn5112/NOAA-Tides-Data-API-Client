package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    void testGetValueToday() {
        assertEquals("today", Date.TODAY.getValue());
    }

    @Test
    void testGetValueLatest() {
        assertEquals("latest", Date.LATEST.getValue());
    }

    @Test
    void testGetValueRecent() {
        assertEquals("recent", Date.RECENT.getValue());
    }

}
