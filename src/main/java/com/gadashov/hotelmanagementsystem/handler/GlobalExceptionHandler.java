package com.gadashov.hotelmanagementsystem.handler;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Map<String, Object>> handle(GlobalException ex, WebRequest request){
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());

        Exceptions exceptions = ex.getExceptions();

        errorAttributes.put("message", exceptions.getMessage());
        errorAttributes.put("status",exceptions.getStatus());
        errorAttributes.put("path", ((ServletWebRequest)request).getRequest().getRequestURI());
        errorAttributes.put("timestamp", LocalDateTime.now());

        return ResponseEntity
                .status(exceptions.getStatus())
                .body(errorAttributes);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handle(MethodArgumentNotValidException ex, WebRequest request){
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        Map<String, Object> invalidFields = new HashMap<>();

        ex.getFieldErrors()
                .forEach(fieldError -> invalidFields.put(fieldError.getField(), fieldError.getDefaultMessage()));

        errorAttributes.put("error", invalidFields);
        errorAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        errorAttributes.put("path", ((ServletWebRequest)request).getRequest().getRequestURI());
        errorAttributes.put("timestamp", LocalDateTime.now());


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorAttributes);
    }



}
