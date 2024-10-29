package net.javaguides.ems_backend.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
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
    public ResponseEntity<ErrorDetail> handleEmailAlreadyFoundException(EmailAlreadyExistsException ex, WebRequest req) {
        ErrorDetail er = new ErrorDetail(
                LocalDateTime.now(),
                ex.getMessage(),
                req.getDescription(false),
                "EMPLOYEE_EMAIL_ALREADY_EXISITS"
        );
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleCommonException(Exception exception, WebRequest request){

        ErrorDetail error = new ErrorDetail(
                LocalDateTime.now(),
                "INTERNAL_COMMON_EXCEPTION",
                exception.getMessage(),
                request.getDescription(false) // if client info need not show then set as false
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        System.out.println("MethodArgumentNotValidException" + ex);
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        System.out.println("ObjectErrorList" + errorList);
        errorList.forEach((er->{
            String fieldName = ((FieldError) er).getField();
            String message = er.getDefaultMessage();
            errors.put(fieldName,message);
        }));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
