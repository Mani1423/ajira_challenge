package com.ajirasoft.challenge.common;

import java.text.MessageFormat;

public class AppError {

    private String errorCode;
    private String errorMessage;

    public AppError() {
        super();
    }

    public AppError(AppErrorCode error) {
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
    }

    public AppError(AppErrorCode error, Object... args) {
        this.errorCode = error.getErrorCode();
        this.errorMessage = MessageFormat.format(error.getErrorMessage(), args);
    }

    public AppError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
