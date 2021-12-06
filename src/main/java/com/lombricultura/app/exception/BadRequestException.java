package com.lombricultura.app.exception;

public class BadRequestException extends RuntimeException{

    // mensaje personalizado
    public BadRequestException(String message){
        super(message);
    }

}
