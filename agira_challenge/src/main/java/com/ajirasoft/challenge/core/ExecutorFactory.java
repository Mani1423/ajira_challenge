package com.ajirasoft.challenge.core;

import com.ajirasoft.challenge.common.AppErrorCode;
import com.ajirasoft.challenge.common.AppException;

public class ExecutorFactory {

    public static Executor getExecutor(String processName) {
        switch (processName) {
            case "DATE_FORMAT":
                return new DateFormatter();
            case "REMOVE_FILTER":
                return new RemoveFilter();
            case "CONCAT":
                return new Concat();
            case "ELIGIBILITY":
                return new Eligibilty();
            default:
                throw new AppException(AppErrorCode.PROCESS_NOT_IMPLEMENTED, processName);
        }
    }
}
