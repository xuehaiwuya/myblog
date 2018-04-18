package com.studyinghome.myblog.common.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-17 09:10
 */
@Setter
@Getter
public class BaseDTO {

    protected Long updateUser;
    protected Long updateTime;
    protected String updateUserName;

}
