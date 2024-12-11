package com.patrick.shinn.noaa.coop.data.client.request.parameters;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Builder(builderClassName = "Builder")
public class Application implements ApiParameter{
    private String name;

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public String getParameter() {
        return "application";
    }

    public static class Builder{
        public Application build(){
            if (name == null || name.isEmpty() || name.isBlank()){
                throw new IllegalArgumentException("application name may not be null or empty.");
            }
            return new Application(name);
        }
    }
}
