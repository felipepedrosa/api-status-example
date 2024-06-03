package dev.felipepedrosa.apistatus.core.usecase;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetApisStatusUseCaseImpl implements UseCase<Map<EnumApis, ApiStatus>> {
    private final ApisStatusContext apisStatusContext;

    private Map<EnumApis, ApiStatus> apisStatus = Collections.emptyMap();

    @Override
    public Map<EnumApis, ApiStatus> execute() {
        return apisStatus;
    }

    @Scheduled(fixedRate = 300000)
    private void getApiStatus() {
        log.info("Getting apis status");
        apisStatus = apisStatusContext.getApisStatus();
    }
}
