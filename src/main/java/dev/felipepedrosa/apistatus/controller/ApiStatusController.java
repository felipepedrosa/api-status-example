package dev.felipepedrosa.apistatus.controller;

import dev.felipepedrosa.apistatus.core.domain.ApiStatus;
import dev.felipepedrosa.apistatus.core.domain.EnumApis;
import dev.felipepedrosa.apistatus.core.usecase.GetApisStatusUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api-status")
@RequiredArgsConstructor
public class ApiStatusController {
    public final GetApisStatusUseCaseImpl getApisStatusUseCase;

    @GetMapping
    public ResponseEntity<Map<EnumApis, ApiStatus>> getStatus() {
        var result = getApisStatusUseCase.execute();
        return ResponseEntity.ok(result);
    }
}
