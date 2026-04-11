package com.assignment18.weather_message_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Global exception handler providing a unified error response structure.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * Catches all unhandled exceptions and returns a 500 Internal Server Error.
     *
     * @param ex The caught exception.
     * @return A map containing error details.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneralException (Exception ex) {
        return Map.of("error", "Internal Server Error", "details", ex.getMessage());
    }
}
