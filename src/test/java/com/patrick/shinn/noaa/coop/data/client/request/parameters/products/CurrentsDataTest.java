package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentsDataTest {

    @Test
    void testGetValueCurrents() {
        assertEquals("currents", CurrentsData.CURRENTS.getValue());
    }

    @Test
    void testGetValueCurrentsPredictions() {
        assertEquals("currents_predictions", CurrentsData.CURRENTS_PREDICTIONS.getValue());
    }

    @Test
    void testEnumValues() {
        CurrentsData[] expectedValues = CurrentsData.values();
        assertEquals(2, expectedValues.length);
        assertEquals(CurrentsData.CURRENTS, expectedValues[0]);
        assertEquals(CurrentsData.CURRENTS_PREDICTIONS, expectedValues[1]);
    }


    @Test
    void getParameter(){
        CurrentsData target = CurrentsData.CURRENTS;
        assertEquals("product", target.getParameter());
    }

}
