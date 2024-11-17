package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeteorologicalDataTest {

    @Test
    void testGetValueAirTemperature() {
        assertEquals("air_temperature", MeteorologicalData.AIR_TEMPERATURE.getValue());
    }

    @Test
    void testGetValueWaterTemperature() {
        assertEquals("water_temperature", MeteorologicalData.WATER_TEMPERATURE.getValue());
    }

    @Test
    void testGetValueWind() {
        assertEquals("wind", MeteorologicalData.WIND.getValue());
    }

    @Test
    void testGetValueAirPressure() {
        assertEquals("air_pressure", MeteorologicalData.AIR_PRESSURE.getValue());
    }

    @Test
    void testGetValueConductivity() {
        assertEquals("conductivity", MeteorologicalData.CONDUCTIVITY.getValue());
    }

    @Test
    void testGetValueVisibility() {
        assertEquals("visibility", MeteorologicalData.VISIBILITY.getValue());
    }

    @Test
    void testGetValueHumidity() {
        assertEquals("humidity", MeteorologicalData.HUMIDITY.getValue());
    }

    @Test
    void testGetValueSalinity() {
        assertEquals("salinity", MeteorologicalData.SALINITY.getValue());
    }

    @Test
    void testEnumValues() {
        MeteorologicalData[] expectedValues = MeteorologicalData.values();
        assertEquals(8, expectedValues.length);
        assertEquals(MeteorologicalData.AIR_TEMPERATURE, expectedValues[0]);
        assertEquals(MeteorologicalData.WATER_TEMPERATURE, expectedValues[1]);
        assertEquals(MeteorologicalData.WIND, expectedValues[2]);
        assertEquals(MeteorologicalData.AIR_PRESSURE, expectedValues[3]);
        assertEquals(MeteorologicalData.CONDUCTIVITY, expectedValues[4]);
        assertEquals(MeteorologicalData.VISIBILITY, expectedValues[5]);
        assertEquals(MeteorologicalData.HUMIDITY, expectedValues[6]);
        assertEquals(MeteorologicalData.SALINITY, expectedValues[7]);
    }


    @Test
    void getParameter(){
        CurrentsData target = CurrentsData.CURRENTS;
        assertEquals("product", target.getParameter());
    }
}
