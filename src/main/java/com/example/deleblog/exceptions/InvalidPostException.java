package com.example.deleblog.exceptions;

public class InvalidPostException extends RuntimeException{
    public InvalidPostException(String s){
        super(s);
    }
}
