package com.studyinghome.myblog.common.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class BaseQuery {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private Long createUser;
    private String createUserName;

}
