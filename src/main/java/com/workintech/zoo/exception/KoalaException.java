package com.workintech.zoo.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class KoalaException extends RuntimeException {
    private HttpStatus status;

    public KoalaException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
