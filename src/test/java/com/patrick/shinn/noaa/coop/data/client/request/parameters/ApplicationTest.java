package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    void testGetValue() {
        Application application = Application.builder()
                .name("MyApp")
                .build();
        assertEquals("MyApp", application.getValue());
    }

    @Test
    void testGetParameter() {
        Application application = Application.builder()
                .name("MyApp")
                .build();
        assertEquals("application", application.getParameter());
    }

    @Test
    void testNameNonNullAndNonEmpty() {
        Application application = Application.builder()
                .name("MyApp")
                .build();
        assertEquals("MyApp", application.getValue());
    }

    @Test
    void testNameNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Application.builder().name(null).build();
        });
        assertEquals("application name may not be null or empty.", thrown.getMessage());
    }

    @Test
    void testNameEmpty() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Application.builder().name("").build());
        assertEquals("application name may not be null or empty.", thrown.getMessage());
    }

    @Test
    void testNameBlank() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Application.builder().name("    ").build());
        assertEquals("application name may not be null or empty.", thrown.getMessage());
    }
}

