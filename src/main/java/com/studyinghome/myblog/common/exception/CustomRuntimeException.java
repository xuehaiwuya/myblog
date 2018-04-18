package com.studyinghome.myblog.common.exception;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class CustomRuntimeException extends RuntimeException {

    protected ExceptionStatus exStatus;

    public CustomRuntimeException(ExceptionStatus exStatus) {
        this.exStatus = exStatus;
    }

}
