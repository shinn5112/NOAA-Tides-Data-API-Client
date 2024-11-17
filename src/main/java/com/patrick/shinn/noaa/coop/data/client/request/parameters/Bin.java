package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Current data and predictions provide information for a specific depth, each depth available for a station has a different Bin number.
 * <ul>
 *  <li>At PORTS (real time currents) stations a bin number is not required, the data is returned using a predefined bin.</li>
 *  <li>If a bin number of 0 (bin=0) is used, data for all bins are provided. (Data Length Limitation: 7 days for all bins)</li>
 *  <li>All other current stations require a bin number to access data.</li>
 *  <li>Historic Survey Current Stations - the Bin numbers / depths for historical survey currents stations are available through the MetaData API</li>
 *  <li>If a bin number of 0 (bin=0) is used, data for all bins is provided. (Data Length Limitation: 7 days for all bins)</li>
 *  <li>Tidal current predictions stations - the Bin number for tidal current prediction stations are available through the MetaData API and Soap Web Services Station Listing</li>
 *  <li>If a bin number is not used, the bin nearest the surface will be provided.</li>
 *  <li>Using an invalid number (like bin=-1) will provide an error message noting the valid bin numbers.</li>
 * </ul>
 */
@Getter
@Builder(builderClassName = "Builder")
public class Bin implements ApiParameter {
    @NonNull
    private Integer binNumber;

    @Override
    public String getValue() {
        return String.valueOf(binNumber);
    }

    @Override
    public String getParameter() {
        return "bin";
    }

    public static class Builder{
        public Bin build(){
            if (binNumber < 0){
                throw new IllegalArgumentException("bin number cannot be negative.");
            }
            return new Bin(binNumber);
        }
    }
}
