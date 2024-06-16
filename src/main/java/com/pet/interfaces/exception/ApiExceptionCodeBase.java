package com.pet.interfaces.exception;

import org.springframework.http.HttpStatus;

public interface ApiExceptionCodeBase {
    HttpStatus getHttpStatus ();
    String getMessage ();
    String getCode ();
}
