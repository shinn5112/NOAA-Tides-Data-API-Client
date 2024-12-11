package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Builder(builderClassName = "Builder")
public class Station implements ApiParameter{
    private String stationId;

    @Override
    public String getValue() {
        return stationId;
    }

    @Override
    public String getParameter() {
        return "station";
    }

    public static class Builder{
        public Station build(){
            if (stationId == null || stationId.isBlank() || stationId.isEmpty()){
                throw new IllegalArgumentException("stationId must have a non-null, non-empty value.");
            }
            return new Station(stationId);
        }
    }
}
