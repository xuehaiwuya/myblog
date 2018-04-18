package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class UserException extends CustomRuntimeException {

    public UserException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
