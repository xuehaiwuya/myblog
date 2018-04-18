package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class CategoryException extends CustomRuntimeException {

    public CategoryException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
