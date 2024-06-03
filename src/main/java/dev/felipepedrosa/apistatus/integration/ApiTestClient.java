package dev.felipepedrosa.apistatus.integration;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;
import dev.felipepedrosa.apistatus.core.usecase.GetApiStatusStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ApiTestClient implements GetApiStatusStrategy {
    private final RestClient client = RestClient.create();

    @Override
    public EnumApis getName() {
        return EnumApis.TEST;
    }

    @Override

    public ApiStatus getStatus() {
        var response = client.get().uri("http://localhost:8080/health").retrieve().toBodilessEntity();
        return new ApiStatus(response.getStatusCode(), "OK");
    }
}
