package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文章(t_article)
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Getter
@Setter
@ToString
public class Article implements Serializable {
    
    private Long id;//文章id
    private String title;//标题
    private String fixedLink;//固定连接
    private String content;//内容
    private String html;//内容html
    private Integer isShow;//是否显示(1:显示，0:不显示)
    private Integer sortValue;//排序
    private Long categoryId;//分类id
    private String categoryName;//分类名称
    private String tags;//标签
    private Long createUser;//创建人
    private String createUserName;//创建人名称
    private Long createTime;//创建时间
    private Long updateUser;//修改人
    private Long updateTime;//修改时间
    private Long pv;//访问次数

}
