package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统资源(t_resource)
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class SysResource implements Serializable {
    
    private Long id;//资源id
    private String url;//网址
    private Long createUser;//创建人
    private Long createTime;//创建时间

}
