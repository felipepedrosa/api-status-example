package dev.felipepedrosa.apistatus.core.usecase;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApisStatusContext {
    private final List<GetApiStatusStrategy> strategies;

    public Map<EnumApis, ApiStatus> getApisStatus() {
        return strategies.stream()
                .collect(Collectors.toMap(GetApiStatusStrategy::getName, GetApiStatusStrategy::getStatus));
    }
}
