package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperationalForecastDataTest {

    @Test
    void testGetValueOFSWaterLevel() {
        assertEquals("ofs_water_level", OperationalForecastData.OFS_WATER_LEVEL.getValue());
    }

    @Test
    void testEnumValues() {
        OperationalForecastData[] expectedValues = OperationalForecastData.values();
        assertEquals(1, expectedValues.length);
        assertEquals(OperationalForecastData.OFS_WATER_LEVEL, expectedValues[0]);
    }


    @Test
    void getParameter(){
        CurrentsData target = CurrentsData.CURRENTS;
        assertEquals("product", target.getParameter());
    }
}
