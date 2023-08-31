package com.workintech.zoo.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class KoalaValidator {

    public static void isIdValid(int id){
        if(id<=0){
            throw new KoalaException("Not a valid ID " +id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdExist(Map koalas, int id){
        if(!koalas.containsKey(id)){
            throw new KoalaException("A Koala with given id does not exist " + id, HttpStatus.BAD_REQUEST);
        }
    }
}
