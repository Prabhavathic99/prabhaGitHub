package net.javaguides.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest req){
        ErrorDetail er = new ErrorDetail(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "EMPLOYEE_NOT_FOUND"
        );
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetail> handleEmailAlreadyFoundException(EmailAlreadyExistsException ex, WebRequest req){
        ErrorDetail er = new ErrorDetail(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "EMPLOYEE_EMAIL_ALREADY_EXISITS"
        );
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
