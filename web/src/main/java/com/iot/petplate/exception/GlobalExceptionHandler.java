package com.iot.petplate.exception;

import com.project.exception.AuthException;
import com.project.exception.BaseException;
import com.project.exception.InvalidValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ConcurrentHashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_OCCURRED_PROCESSING_THE_REQUEST = "Ocurrió un error procesando la solicitud. Por favor contacta al administrador del sistema.";

    private static final ConcurrentHashMap<String, HttpStatus> STATES = new ConcurrentHashMap<>();

    public GlobalExceptionHandler() {
        STATES.put(AuthException.class.getSimpleName(), HttpStatus.FORBIDDEN);
        STATES.put(InvalidValueException.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> exceptionResolver(BaseException e) {
        HttpStatus status = STATES.get(e.getClass().getSimpleName());
        ErrorResponse err = new ErrorResponse(e.getClass().getSimpleName(), e.getTechnicalMessage(), e.getHumanMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionResolver(Exception e) {
        ErrorResponse err = new ErrorResponse(e.getClass().getSimpleName(), e.getMessage(), ERROR_OCCURRED_PROCESSING_THE_REQUEST);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

}