package com.studyinghome.myblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 评论(t_comment)
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class Comment implements Serializable {
    
    private Long id;//评论id
    private String nickName;//昵称
    private String email;//邮箱
    private String site;//网址
    private String content;//内容
    private Long parentId;//父评论id
    private Long commentObj;//评论对象
    private String toNickName;//回复目标人
    private Integer status;//评论状态
    private Long createTime;//创建时间
    private Long auditUser;//审核人
    private Long auditTime;//审核时间

}
