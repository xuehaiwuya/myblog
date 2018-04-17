package org.xxz.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统参数(t_param)
 * @author tt
 *
 */
@Setter
@Getter
@ToString
public class SysParam implements Serializable {
    
    private String paramName;
    private String paramValue;
    private Long createUser;
    private Long createTime;
    private Long updateUser;
    private Long updateTime;

}
