package mierim.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StanderdError> objectNotFaundException(ObjectNotFoundException ex, HttpServletRequest request){
         StanderdError error = new StanderdError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                 "Object Not Found", ex.getMessage(), request.getRequestURI());
                     return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
