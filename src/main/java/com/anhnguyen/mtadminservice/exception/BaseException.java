package com.anhnguyen.mtadminservice.exception;

import com.anhnguyen.mtadminservice.common.ErrorType;
import lombok.Getter;


/**
 * @author Rin
 */

@Getter
public class BaseException extends RuntimeException {

    private ErrorType errorType;

    public BaseException() {
        this.errorType = ErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }
}
