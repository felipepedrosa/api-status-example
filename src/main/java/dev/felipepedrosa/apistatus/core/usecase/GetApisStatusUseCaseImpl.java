package dev.felipepedrosa.apistatus.core.usecase;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetApisStatusUseCaseImpl implements UseCase<Map<EnumApis, ApiStatus>> {
    public final ApisStatusContext apisStatusContext;

    @Override
    public Map<EnumApis, ApiStatus> execute() {
        return apisStatusContext.getApisStatus();
    }
}
