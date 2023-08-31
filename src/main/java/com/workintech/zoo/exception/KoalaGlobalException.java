package com.workintech.zoo.exception;

import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KoalaGlobalException {
    @ExceptionHandler
    public ResponseEntity<KoalaErrorResponse> handleKoalaException(KoalaException exception){
        KoalaErrorResponse response = new KoalaErrorResponse(exception.getStatus().value(), exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response,exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<KoalaErrorResponse> handleKoalaException(Exception exception){
        KoalaErrorResponse response = new KoalaErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


}
