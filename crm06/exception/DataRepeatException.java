package com.wnxy.crm06.exception;

public class DataRepeatException extends RuntimeException {
    //重写构造函数


    public DataRepeatException() {
        super();
    }

    public DataRepeatException(String message) {
        super(message);
    }

    public DataRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataRepeatException(Throwable cause) {
        super(cause);
    }

    protected DataRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
