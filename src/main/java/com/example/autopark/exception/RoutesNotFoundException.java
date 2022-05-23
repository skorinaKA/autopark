package com.example.autopark.exception;

public class RoutesNotFoundException extends RuntimeException{
    public RoutesNotFoundException(String m){
        super(m);
    }
}
