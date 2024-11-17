package com.patrick.shinn.noaa.coop.data.client.request.parameters.products;

import com.patrick.shinn.noaa.coop.data.client.request.parameters.ApiParameter;

public interface ApiDataProductParameter extends ApiParameter {
    @Override
    default String getParameter() {
        return "product";
    }
}
