package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统参数(t_param)
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class SysParam implements Serializable {
    
    private String paramName;//参数名称
    private String paramValue;//参数值
    private Long createUser;//创建人
    private Long createTime;//创建时间
    private Long updateUser;//修改人
    private Long updateTime;//修改时间

}
