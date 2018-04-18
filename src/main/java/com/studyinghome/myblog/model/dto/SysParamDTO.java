package com.studyinghome.myblog.model.dto;

import com.studyinghome.myblog.common.bean.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class SysParamDTO extends BaseDTO {

    @NotBlank(message = "参数名称不能为空")
    private String paramName;
    @NotBlank(message = "参数值不能为空")
    private String paramValue;

}
