package com.patrick.shinn.noaa.coop.data.client.request.parameters;

/**
 * Interface for common API GET parameter functions.
 * @since 1.0.0
 * @author Patrick Shinn
 */
public interface ApiParameter {
    /** Gets the selected enum value for the parameter. */
    String getValue();
    /** Gets the parameter name as sent in the GET request. */
    String getParameter();
    /** Creates the GET request ready argument for the parameter. */
    default String getRequestArgument(){
        return String.format("%s=%s", getParameter(), getValue());
    }
}
