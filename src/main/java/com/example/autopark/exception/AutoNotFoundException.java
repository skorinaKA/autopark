package com.example.autopark.exception;

public class AutoNotFoundException extends RuntimeException{
    public AutoNotFoundException(String message){
        super(message);
    }
}
