package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分类(t_category)
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class Category implements Serializable {
    
    private Long id;//分类id
    private String name;//分类名称
    private String aliasName;//分类别名
    private Long createUser;//创建人
    private Long createTime;//创建时间
    private Long updateUser;//修改人
    private Long updateTime;//修改时间

}
