package com.studyinghome.myblog.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * ${用户登录日志(t_user_log)}
 *
 * @author panxiang
 * @create 2018-04-17 22:07
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLog implements Serializable {

    private Long id;//主键
    private Long userId;//用户id
    private Date loginTime;//登录时间
    private Integer loginStat;//登录状态
    private Integer loginErrorCount;//登录错误次数
    
}
