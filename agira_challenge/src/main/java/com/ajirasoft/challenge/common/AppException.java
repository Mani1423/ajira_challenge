package com.ajirasoft.challenge.common;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4345763084076906197L;
    private final List<AppError> errors;

    public AppException() {
        super(AppConstant.EXCEPTION_DEFAULT_MESSAGE);
        this.errors = null;
    }

    /**
     * Exception with HttpStatus and list of errors
     *
     * @param errors
     */
    public AppException(String message, List<AppError> errors) {
        super(message);
        this.errors = errors;
    }

    /**
     * Exception with HttpStatus and list of errors
     *
     * @param errors
     * @param cause
     */
    public AppException(String message, List<AppError> errors, Throwable cause) {
        super(message,cause);
        this.errors = errors;
    }

    /**
     * Exception with HttpStatus and list of errors
     *
     * @param error
     */
    public AppException(String message, AppError error) {
        super(message);
        this.errors = new ArrayList<>();
        this.errors.add(error);
    }

    /**
     * Exception with httpStatus, errorCode and errorMessage
     *
     * @param errorCode
     * @param args
     */
    public AppException(AppErrorCode errorCode, Object... args) {
        super(MessageFormat.format(errorCode.getErrorMessage(), args));
        String errorMessage = MessageFormat.format(errorCode.getErrorMessage(), args);
        this.errors = Collections.singletonList(new AppError(errorCode, errorMessage));
    }

    /**
     * Exception with httpStatus, errorCode and errorMessage
     *
     * @param errorCode
     * @param errorMsg
     * @param cause
     */
    public AppException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errors = Collections.singletonList(new AppError(errorCode, errorMsg));
    }

    /**
     * Exception with Http Status and Error codes
     *
     * @param umbErrorCodes
     * @param cause
     */
    public AppException(AppErrorCode umbErrorCodes, Throwable cause) {
        this(umbErrorCodes.getErrorCode(), umbErrorCodes.getErrorMessage(), cause);
    }

    /**
     * Exception with Http Status and Error codes
     *
     * @param umbErrorCode
     * @param cause
     * @param args
     */
    public AppException(AppErrorCode umbErrorCode, Throwable cause, Object...args) {
        this(umbErrorCode.getErrorCode(), MessageFormat.format(umbErrorCode.getErrorMessage(), args), cause);
    }

    public List<AppError> getErrors() {
        return errors;
    }
}
