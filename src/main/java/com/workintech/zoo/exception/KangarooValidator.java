package com.workintech.zoo.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class KangarooValidator {

    public static void isIdValid(int id){
        if(id<=0){
            throw new KangarooException("Not a valid ID " +id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdExist(Map kangaroos, int id){
        if(!kangaroos.containsKey(id)){
            throw new KangarooException("A Kangaroo with given id does not exist " + id, HttpStatus.BAD_REQUEST);
        }
    }
}
