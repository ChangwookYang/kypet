package com.pet.interfaces.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Getter
@Schema(description = "Error response")
public class ErrorResponse {
    @Schema(description = "code", example = "VR401", requiredMode = REQUIRED)
    private String code;
    @Schema(description = "message", example = "unauthorized", requiredMode = REQUIRED)
    private String message;

    public ErrorResponse(ApiException apiException) {
        this.code = apiException.getCode();
        this.message = String.join(", ", apiException.getMessages());
    }
}
