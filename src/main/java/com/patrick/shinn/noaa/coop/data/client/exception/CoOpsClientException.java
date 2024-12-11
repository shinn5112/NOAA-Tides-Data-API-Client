package com.patrick.shinn.noaa.coop.data.client.exception;

/**
 * General catch all exception for the {@link com.patrick.shinn.noaa.coop.data.client.CoOpsClient}
 */
public class CoOpsClientException extends RuntimeException {
    public CoOpsClientException(String message) {
        super(message);
    }

    public CoOpsClientException(Throwable ex){
        super(ex);
    }
}
