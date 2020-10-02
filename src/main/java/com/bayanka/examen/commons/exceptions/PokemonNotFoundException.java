package com.bayanka.examen.commons.exceptions;


public class PokemonNotFoundException extends Exception {

    protected final int errorCode;
    protected final String message;

    public PokemonNotFoundException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public PokemonNotFoundException(int errorCode, Throwable exception) {
        super(exception);
        this.errorCode = errorCode;
        this.message = exception.getMessage();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
