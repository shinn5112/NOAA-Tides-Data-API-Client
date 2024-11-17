package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinTest {

    @Test
    void testGetValue() {
        Bin bin = Bin.builder()
                .binNumber(5)
                .build();
        assertEquals("5", bin.getValue());
    }

    @Test
    void testGetParameter() {
        Bin bin = Bin.builder()
                .binNumber(5)
                .build();
        assertEquals("bin", bin.getParameter());
    }

    @Test
    void testBinNumberPositive() {
        Bin bin = Bin.builder()
                .binNumber(5)
                .build();
        assertEquals(5, bin.getBinNumber());
    }

    @Test
    void testBinNumberNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Bin.builder().binNumber(-1).build();
        });
        assertEquals("bin number cannot be negative.", thrown.getMessage());
    }

    @Test
    void testBinNumberZero() {
        Bin bin = Bin.builder()
                .binNumber(0)
                .build();
        assertEquals(0, bin.getBinNumber());
    }

    @Test
    void testNonNullBinNumber() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            Bin.builder().build();
        });
        assertNotNull(thrown.getMessage());
    }
}
