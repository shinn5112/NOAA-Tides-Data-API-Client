package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormatTest {

    @Test
    void testGetValueXML() {
        assertEquals("xml", Format.XML.getValue());
    }

    @Test
    void testGetValueJSON() {
        assertEquals("json", Format.JSON.getValue());
    }

    @Test
    void testGetValueCSV() {
        assertEquals("csv", Format.CSV.getValue());
    }

    @Test
    void testGetParameter() {
        for (Format format : Format.values()) {
            assertEquals("format", format.getParameter());
        }
    }
}
