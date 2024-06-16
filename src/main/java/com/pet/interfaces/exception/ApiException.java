package com.pet.interfaces.exception;

import lombok.Getter;

@Getter
public class ApiException extends AbstractApiException {
    private ApiExceptionCodeBase apiExceptionCode;

    public ApiException(ApiExceptionCodeBase apiExceptionCode) {
        super(apiExceptionCode.getMessage());
        this.apiExceptionCode = apiExceptionCode;
        this.code = apiExceptionCode.getCode();
        this.setStatus(apiExceptionCode.getHttpStatus());
        this.setMessage(apiExceptionCode.getMessage());
    }
}
