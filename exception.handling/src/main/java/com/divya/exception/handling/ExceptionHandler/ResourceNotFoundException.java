package com.divya.exception.handling.ExceptionHandler;

import org.springframework.stereotype.Component;


public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String message) {
        super(message);
    }

}
