package com.studyinghome.myblog.common.exception;

/**
 * @author tt
 */
public class CustomRuntimeException extends RuntimeException {

    protected ExceptionStatus exStatus;

    public CustomRuntimeException(ExceptionStatus exStatus) {
        this.exStatus = exStatus;
    }

}
