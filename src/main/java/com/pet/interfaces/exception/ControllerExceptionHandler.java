package com.pet.interfaces.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static com.pet.interfaces.response.ApiResponseCode.INTERNAL_SERVER_ERROR;


@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public HttpEntity<Object> handleException(HttpServletRequest request, Exception e) {
        log.error(e.getClass().getName(), e);
        return new ResponseEntity<>(new ErrorResponse(new ApiException(INTERNAL_SERVER_ERROR)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(final ApiException apiException,
                                                            final WebRequest webRequest) {
        final HttpStatus httpStatus = apiException.getStatus();

        if (httpStatus.is5xxServerError()) {
            log.error(apiException.getClass().getName(), apiException);
        }

        return new ResponseEntity<>(new ErrorResponse(apiException), httpStatus);
    }

}