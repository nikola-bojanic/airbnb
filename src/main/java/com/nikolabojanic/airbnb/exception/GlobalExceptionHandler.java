package com.nikolabojanic.airbnb.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = AirbnbValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleAirbnbValidationException(AirbnbValidationException e, WebRequest request) {
        return handleException(e, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e, WebRequest request) {
        return handleException(e, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleException(e, status, request);
    }

    private ResponseEntity<Object> handleException(Exception e, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), status, request);
    }

}
