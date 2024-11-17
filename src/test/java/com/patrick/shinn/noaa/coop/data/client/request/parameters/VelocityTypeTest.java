package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VelocityTypeTest {

    @Test
    void testGetValueSpeedDir() {
        assertEquals("speed_dir", VelocityType.SPEED_DIR.getValue());
    }

    @Test
    void testGetValueDefault() {
        assertEquals("default", VelocityType.DEFAULT.getValue());
    }

    @Test
    void testGetParameter() {
        for (VelocityType type : VelocityType.values()) {
            assertEquals("Vel_type", type.getParameter());
        }
    }
}
