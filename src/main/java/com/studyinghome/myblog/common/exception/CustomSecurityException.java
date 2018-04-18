package com.studyinghome.myblog.common.exception;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class CustomSecurityException extends CustomRuntimeException {

    public CustomSecurityException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
