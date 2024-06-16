package com.pet.interfaces.response;

import com.pet.interfaces.exception.ApiExceptionCodeBase;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiResponseCode implements ApiExceptionCodeBase {
    SUCCESS(HttpStatus.OK, "KY200", "success"),
    CREATE(HttpStatus.CREATED, "KY201", "created"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "KY400", "bad request"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "KY401", "unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "KY403", "forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "KY404", "not found"),
    CONFLICT(HttpStatus.CONFLICT, "KY409", "conflict"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "KY500", "internal server error");

    private HttpStatus httpStatus;
    private String code;
    private String message;

    ApiResponseCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
