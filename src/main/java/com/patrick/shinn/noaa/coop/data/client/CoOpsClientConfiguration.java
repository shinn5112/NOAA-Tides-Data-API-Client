package com.patrick.shinn.noaa.coop.data.client;

import lombok.Builder;
import lombok.Getter;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * CoOps Client Configuration. The configuration provides sensible defaults, but allows for the customization of
 * several aspects of the {@link CoOpsClient}.
 * @since 1.0.0
 * @author Patrick Shinn
 */
@Getter
@Builder
public class CoOpsClientConfiguration {
    @Builder.Default
    private Duration timeout = Duration.ofSeconds(30);
    @Builder.Default
    private HttpClient client = HttpClient.newHttpClient();
}
