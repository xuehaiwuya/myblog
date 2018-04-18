package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统资源(t_resource)
 * @author tt
 *
 */
@Setter
@Getter
@ToString
public class SysResource implements Serializable {
    
    private Long id;
    private String url;
    private Long createUser;
    private Long createTime;

}
