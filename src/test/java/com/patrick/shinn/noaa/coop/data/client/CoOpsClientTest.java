package com.patrick.shinn.noaa.coop.data.client;

import com.patrick.shinn.noaa.coop.data.client.request.ApiDataRequest;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.*;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.products.WaterData;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.time.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoOpsClientTest {

    private CoOpsClient target;

    @Test
    void funTime(){
        target = new CoOpsClient(CoOpsClientConfiguration.builder().build());
        ApiDataRequest apiDataRequest = ApiDataRequest.builder()
                .date(Date.TODAY)
                .station(Station.builder().stationId("8658163").build())
                .product(WaterData.PREDICTIONS)
                .datum(Datum.MSL)
                .units(Units.ENGLISH)
                .timeZone(TimeZone.LST)
                .interval(Interval.MAX_SLACK)
                .build();
        target.makeRequest(apiDataRequest);
    }

}