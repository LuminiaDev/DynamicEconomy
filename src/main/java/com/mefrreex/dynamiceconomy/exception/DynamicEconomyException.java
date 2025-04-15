package com.mefrreex.dynamiceconomy.exception;

public class DynamicEconomyException extends RuntimeException {

    public DynamicEconomyException(String message) {
        super(message);
    }

    public DynamicEconomyException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
