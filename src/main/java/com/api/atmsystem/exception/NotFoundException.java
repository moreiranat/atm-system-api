package com.api.atmsystem.exception;

import org.springframework.validation.Errors;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {

        super("Customer not found.");
    }

}
