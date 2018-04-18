package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * ${文章异常}
 *
 * @author panxiang
 * @create 2018-04-17 23:07
 */
public class ArticleException extends CustomRuntimeException {

    public ArticleException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
