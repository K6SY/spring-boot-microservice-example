package com.orange.sonatel.malado.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserIntrouvableException extends RuntimeException {

    public UserIntrouvableException(String message) {
        super(message);
    }

    public UserIntrouvableException() {
        super();
    }

    public UserIntrouvableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIntrouvableException(Throwable cause) {
        super(cause);
    }
}
