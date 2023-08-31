package com.workintech.zoo.exception;

import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KangarooGlobalException {
    @ExceptionHandler
    public ResponseEntity<KangarooErrorResponse> handleKangarooException(KangarooException exception){
        KangarooErrorResponse response = new KangarooErrorResponse(exception.getStatus().value(), exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response,exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<KangarooErrorResponse> handleKangarooException(Exception exception){
        KangarooErrorResponse response = new KangarooErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
