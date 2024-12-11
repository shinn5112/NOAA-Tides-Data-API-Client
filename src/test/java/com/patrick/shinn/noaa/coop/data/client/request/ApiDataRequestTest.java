package com.patrick.shinn.noaa.coop.data.client.request;

import com.patrick.shinn.noaa.coop.data.client.request.parameters.*;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.products.WaterData;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.time.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiDataRequestTest {
    ApiDataRequest target;

    @Test
    void getRequestValidatesNonNull() {
        assertThrows(NullPointerException.class, () -> target = ApiDataRequest.builder()
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .build());

        assertThrows(NullPointerException.class, () -> target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .format(Format.CSV)
                .build());

        assertThrows(NullPointerException.class, () -> target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .build());

        assertThrows(NullPointerException.class, () -> target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .units(Units.ENGLISH)
                .build());

        assertThrows(NullPointerException.class, () -> target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .build());

        // should throw no error as all required parameters are set
        target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .build();


    }

    @Test
    void getRequestFormatsParametersCorrectly(){
        String actualRequest;
        String expectedBaseRequest = "date=today&station=test&product=air_gap&time_zone=gmt&units=english&format=csv&application=noaa-coops-data-api-client-java";
        // base required values
        target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .format(Format.CSV)
                .build();
        actualRequest = target.getRequest();
        assertEquals(expectedBaseRequest, actualRequest);

        // ensure optional parameters are added correctly
        target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .format(Format.CSV)
                .interval(Interval.HOURLY)
                .build();
        actualRequest = target.getRequest();
        assertEquals(expectedBaseRequest + "&interval=h", actualRequest);
    }

    @Test
    void defaultValues(){
        target = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("test").build())
                .product(WaterData.AIR_GAP)
                .timeZone(TimeZone.GMT)
                .units(Units.ENGLISH)
                .build();

        assertEquals(Format.JSON, target.getFormat());
        assertEquals(
                Application.builder().name("noaa-coops-data-api-client-java").build(),
                target.getApplication()
        );
    }
}