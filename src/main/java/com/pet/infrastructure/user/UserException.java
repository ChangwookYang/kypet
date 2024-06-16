package com.pet.infrastructure.user;

import com.pet.interfaces.exception.ApiExceptionCodeBase;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum UserException implements ApiExceptionCodeBase {

    NOT_EXIST_USER(BAD_REQUEST, "U001",  "회원 정보가 존재하지 않습니다."),
    ;

    private HttpStatus httpStatus;
    private String code;
    private String message;

    UserException(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
