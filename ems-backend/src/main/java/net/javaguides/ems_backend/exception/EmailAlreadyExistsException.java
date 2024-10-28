package net.javaguides.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException{

    private String msg;

    public EmailAlreadyExistsException(String msg){
        super(msg);
    }
}
