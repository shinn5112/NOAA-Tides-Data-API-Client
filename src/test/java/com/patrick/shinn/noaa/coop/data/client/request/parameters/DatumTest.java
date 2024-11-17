package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatumTest {

    @Test
    void testGetValueCRD() {
        assertEquals("CRD", Datum.CRD.getValue());
    }

    @Test
    void testGetValueIGLD() {
        assertEquals("IGLD", Datum.IGLD.getValue());
    }

    @Test
    void testGetValueLWD() {
        assertEquals("LWD", Datum.LWD.getValue());
    }

    @Test
    void testGetValueMHHW() {
        assertEquals("MHHW", Datum.MHHW.getValue());
    }

    @Test
    void testGetValueMHW() {
        assertEquals("MHW", Datum.MHW.getValue());
    }

    @Test
    void testGetValueMTL() {
        assertEquals("MTL", Datum.MTL.getValue());
    }

    @Test
    void testGetValueMSL() {
        assertEquals("MSL", Datum.MSL.getValue());
    }

    @Test
    void testGetValueMLW() {
        assertEquals("MLW", Datum.MLW.getValue());
    }

    @Test
    void testGetValueMLLW() {
        assertEquals("MLLW", Datum.MLLW.getValue());
    }

    @Test
    void testGetValueNAVD() {
        assertEquals("NAVD", Datum.NAVD.getValue());
    }

    @Test
    void testGetValueSTND() {
        assertEquals("STND", Datum.STND.getValue());
    }

    @Test
    void testGetParameter() {
        for (Datum datum : Datum.values()) {
            assertEquals("datum", datum.getParameter());
        }
    }
}
