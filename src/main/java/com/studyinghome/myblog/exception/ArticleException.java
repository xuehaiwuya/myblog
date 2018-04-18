package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class ArticleException extends CustomRuntimeException {

    public ArticleException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
