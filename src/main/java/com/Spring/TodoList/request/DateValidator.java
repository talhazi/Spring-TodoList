package com.Spring.TodoList.request;

/**
 * Interface for the {@link DateValidatorUsingLocalDate} class, the class that implements the interface has to implement
 * the method isValid.
 */
public interface DateValidator {
    boolean isValid(String dateStr);
}