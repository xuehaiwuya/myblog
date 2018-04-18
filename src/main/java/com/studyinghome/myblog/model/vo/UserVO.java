package com.studyinghome.myblog.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-18 09:12
 */
@Setter
@Getter
@ToString
public class UserVO implements Serializable {

    private static final long serialVersionUID = -5917866271118861427L;
    
    private Long id;//主键id
    private String username;//用户名
    private String nickName;//昵称
    private Date createTime;//创建时间

}
