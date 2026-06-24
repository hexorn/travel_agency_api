package com.epam.finaltask.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(
            ConstraintViolationException ex) {

        Map<String, String> errors = ex.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(
                        v -> v.getPropertyPath().toString(),
                        ConstraintViolation::getMessage
                ));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidEnum(HttpMessageNotReadableException ex) {

        return ResponseEntity
                .badRequest()
                .body(Map.ofEntries(Map.entry("error", "Invalid value: " + ex.getMessage())));
    }

    @ExceptionHandler(UserEntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserEntityNotFoundException(UserEntityNotFoundException ex) {

        return ResponseEntity
                .badRequest()
                .body(Map.ofEntries(Map.entry("error", ex.getMessage())));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCredentialsException(InvalidCredentialsException ex) {

        return ResponseEntity
                .badRequest()
                .body(Map.ofEntries(Map.entry("error", ex.getMessage())));
    }
}
