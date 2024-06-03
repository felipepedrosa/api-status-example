package dev.felipepedrosa.apistatus.core.usecase;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;

public interface GetApiStatusStrategy {
    EnumApis getName();

    ApiStatus getStatus();
}


