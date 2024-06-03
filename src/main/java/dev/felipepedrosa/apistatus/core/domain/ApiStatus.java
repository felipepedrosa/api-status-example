package dev.felipepedrosa.apistatus.core.domain;

import org.springframework.http.HttpStatusCode;

public record ApiStatus(HttpStatusCode status, String description) {

}
