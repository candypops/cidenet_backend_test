package com.cidenet.cidenet.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    private ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "JSON mal formateado";
        int code = 1;
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, code));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
        Optional<ObjectError> firstError = ex.getBindingResult().getAllErrors().stream().findFirst();
        int code = 1;
        if (firstError.isPresent()) {
            final String firstErrorMessage = firstError.get().getDefaultMessage();
            return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, firstErrorMessage, code));
        }
        String error = "MethodArgumentNotValidException";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, code));

    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<Object> handleJsonMappingException(JsonMappingException ex) {
        String error = "JsonMappingException";
        int code = 2;
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex, code));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException ex) {
        String error = "SQLException";
        int code = 3;
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex, code));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = "Recurso no encotrado";
        int code = 4;
        return buildResponseEntity(new ApiError(HttpStatus.OK, message, ex, code));
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    private ResponseEntity<Object> handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex) {
        String error = "JSON mal formateado";
        int code = 2;
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex, code));
    }

    @ExceptionHandler(DuplicateIdentificationException.class)
    public ResponseEntity<Object> handleDuplicateIdentificationException(DuplicateIdentificationException ex) {
        String message = "Identificacion Repetida";
        int code = 5;
        return buildResponseEntity(new ApiError(HttpStatus.OK, message, ex, code));
    }

    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<Object> handleUnexpectedErrorExceptionException(UnexpectedErrorException ex) {
        String message = "Error inesperado";
        int code = 999;
        return buildResponseEntity(new ApiError(HttpStatus.OK, message, code));
    }
}
