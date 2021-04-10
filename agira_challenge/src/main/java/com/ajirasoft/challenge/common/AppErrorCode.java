package com.ajirasoft.challenge.common;

public enum AppErrorCode {
    PATH_INVALID("PATH-INVALID", "Input path should not be null or empty"),
    FILE_NOT_FOUND("FILE-NOT-FOUND", "File not found at location : {0}"),
    FILE_READ_FAILED("FILE-READ-FAILURE", "Error while reading the file at location : {0}"),
    FILE_WRITE_FAILED("FILE-WRITE-FAILURE", "Error while writing the file at location : {0}"),
    PROCESS_NOT_IMPLEMENTED("PROCESS-NOT-IMPLEMENTED", "The requested process {0} not implemented. Contact administrator");

    private final String errorCode;
    private final String errorMessage;

    AppErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public String toString() {
        return this.errorCode + " " + this.errorMessage;
    }
}
