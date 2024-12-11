package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import com.patrick.shinn.noaa.coop.data.client.exception.ApiDataProductException;
import com.patrick.shinn.noaa.coop.data.client.request.parameters.ApiParameter;

import java.util.Map;

/**
 * Extension of the {@link ApiParameter} interface, including specialized methods for API Data Products.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public interface ApiDataProductParameter extends ApiParameter {
    /**
     * Validates that required {@link ApiParameter}s are included for the requested Data Product and that
     * any provided parameters have allowed values.
     * By default, there are no required parameters, however, an implementing class may elect to require a
     * Map of required parameters and accepted values. If an entry exists for a parameter but maps to a null or empty
     * value,the parameter is expected to accept any value. In the event that a required parameter is missing
     * or an invalid value is provided, an {@link ApiDataProductException} will be thrown.
     * @throws ApiDataProductException when a required parameter is missing or an invalid value is provided.
     * @since 1.0.0
     */
    default void validateParameters(Map<Class<? extends ApiParameter>, ApiParameter> actualParameters) throws ApiDataProductException {
        // does nothing by default
    }
    @Override
    default String getParameter() {
        return "product";
    }
}
