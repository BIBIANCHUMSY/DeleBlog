package com.example.deleblog.exceptions;

public class PostNotAllowedException extends RuntimeException {
    public PostNotAllowedException(String s) {
        super(s);
    }
}
