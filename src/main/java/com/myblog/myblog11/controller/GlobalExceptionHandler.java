package com.myblog.myblog11.controller;



import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.ErrorDetalis;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalis> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
      ErrorDetalis errorDetalis = new ErrorDetalis(e.getMessage(),new Date(),webRequest.getDescription(true));
        return new ResponseEntity<>(errorDetalis, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
