package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents the supported response formats for the API.
 * @since 1.0.0
 * @author Patrick Shinn
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Format implements ApiParameter{
    XML("xml"),
    JSON("json"),
    CSV("csv");

    private final String value;

    @Override
    public String getParameter() {
        return "format";
    }
}
