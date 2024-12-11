package com.patrick.shinn.noaa.coop.data.client.exception;

/**
 * General {@link com.patrick.shinn.noaa.coop.data.client.request.parameters.products.ApiDataProductParameter}
 * exception.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public class ApiDataProductException extends RuntimeException {
    public ApiDataProductException(String message) {
        super(message);
    }
}
