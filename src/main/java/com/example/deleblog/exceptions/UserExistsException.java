package com.example.deleblog.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String s){
        super(s);
    }
}
