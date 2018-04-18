package com.studyinghome.myblog.exception;

import com.studyinghome.myblog.common.exception.CustomRuntimeException;
import com.studyinghome.myblog.common.exception.ExceptionStatus;

/**
 * ${用户操作异常}
 *
 * @author panxiang
 * @create 2018-04-17 20:15
 */
public class UserException extends CustomRuntimeException {

    public UserException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
