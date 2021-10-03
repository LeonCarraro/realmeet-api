package com.leoncarraro.realmeetservice.exception.handler;

import com.leoncarraro.realmeetservice.exception.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({ RoomNotFoundException.class })
    public ResponseEntity<Object> notFoundExceptionHandler(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
