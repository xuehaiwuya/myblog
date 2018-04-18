package com.studyinghome.myblog.entity;

import com.studyinghome.myblog.common.security.IUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ${用户(t_user)}
 *
 * @author panxiang
 * @create 2018-04-17 22:07
 */
@Getter
@Setter
@ToString
public class User implements IUser {

    private Long id;//用户id
    private String username;//用户名
    private String password;//密码
    private String nickName;//昵称
    private Long createTime;//创建时间
    
}
