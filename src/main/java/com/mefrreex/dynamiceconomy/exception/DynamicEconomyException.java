package com.mefrreex.dynamiceconomy.exception;

/**
 * Custom exception class for DynamicEconomy-related errors.
 */
public class DynamicEconomyException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message (saved for later retrieval)
     */
    public DynamicEconomyException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause (saved for later retrieval)
     */
    public DynamicEconomyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause (saved for later retrieval)
     */
    public DynamicEconomyException(Throwable cause) {
        super(cause);
    }
}
