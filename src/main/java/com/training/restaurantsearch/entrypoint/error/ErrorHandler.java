package com.training.restaurantsearch.entrypoint.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<String> violations = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(toList());
        LOG.warn("Constraint violations: {}", violations, ex);
        return ResponseEntity.badRequest().body(new ErrorResponse(violations));
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorResponse> handleGenericError(Exception ex, WebRequest request) {
        LOG.warn("Internal error: {}", ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(new ErrorResponse(List.of("Internal server error")));
    }
}
