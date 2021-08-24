package com.security.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordException extends RuntimeException{

    public PasswordException(final String message) {
        super(message);
    }

}
