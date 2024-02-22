package com.gadashov.hotelmanagementsystem.handler;

import com.gadashov.hotelmanagementsystem.model.dto.response.ExceptionResponse;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ExceptionResponse> handle(GlobalException exception){
        List<String> message = List.of(exception.getExceptions().getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getExceptions().getStatus().value(),message);
        return ResponseEntity.status(exception.getExceptions().getStatus()).body(exceptionResponse);
    }
}
