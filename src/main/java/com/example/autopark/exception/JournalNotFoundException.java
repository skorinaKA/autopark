package com.example.autopark.exception;

public class JournalNotFoundException extends RuntimeException {
    public JournalNotFoundException(String message){
        super(message);
    }
}