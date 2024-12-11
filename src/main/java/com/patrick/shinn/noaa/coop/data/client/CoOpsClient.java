package com.patrick.shinn.noaa.coop.data.client;

import com.patrick.shinn.noaa.coop.data.client.exception.CoOpsClientException;
import com.patrick.shinn.noaa.coop.data.client.request.ApiDataRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @since 1.0.0
 * @author Patrick Shinn
 */
@Slf4j
@AllArgsConstructor
public class CoOpsClient {
    private static final String BASE_URL = "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?";
    private CoOpsClientConfiguration configuration;

    public void makeRequest(ApiDataRequest request){
        try {
            HttpResponse<String> response = configuration.getClient().send(
                    buildRequest(request),
                    HttpResponse.BodyHandlers.ofString()
            );
            log.info(response.body());
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            log.error(ex.getMessage());
            throw new CoOpsClientException(ex);
        }
    }

    public void makeRequestAsync(ApiDataRequest request){

    }

    private HttpRequest buildRequest(ApiDataRequest apiDataRequest) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + apiDataRequest.getRequest()))
                .GET()
                .timeout(configuration.getTimeout())
                .build();
    }
}
