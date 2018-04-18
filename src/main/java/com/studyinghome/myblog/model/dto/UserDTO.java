package com.studyinghome.myblog.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import com.studyinghome.myblog.common.bean.BaseDTO;

/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-18 09:21
 */
@Setter
@Getter
@ToString
public class UserDTO extends BaseDTO {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String nickName;

}
