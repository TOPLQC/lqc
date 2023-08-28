package com.wnxy.crm_v05.exception;

//异常类必须继承Exception或RunTimeException类，同时类名也必须以Exception结束
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
