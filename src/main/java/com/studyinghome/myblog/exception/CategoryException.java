package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * ${分类异常}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class CategoryException extends CustomRuntimeException {

    public CategoryException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
