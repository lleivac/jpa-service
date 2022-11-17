package com.lucia.jpaservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<Error> ResourceAlreadyExistException(Exception ex){
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.setStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> ResourceNotFoundException(Exception ex) {
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.getStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> IllegalArgumentException(Exception ex){
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.getStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

        }
