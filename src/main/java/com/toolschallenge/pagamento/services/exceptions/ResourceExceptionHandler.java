package com.toolschallenge.pagamento.services.exceptions;

import com.toolschallenge.pagamento.resources.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError responseError = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<StandardError> validateException(ValidateException exception, HttpServletRequest request){
        String error = "Validate Error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError responseError = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
        String error = "Validate Error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError responseError = new StandardError(Instant.now(), status.value(), error,
                exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(responseError);
    }
}
