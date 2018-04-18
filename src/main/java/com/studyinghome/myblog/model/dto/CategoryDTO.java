package com.studyinghome.myblog.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import com.studyinghome.myblog.common.bean.BaseDTO;

/**
 * ${分类 dto}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class CategoryDTO extends BaseDTO {
    
    private static final long serialVersionUID = -3367173869874734353L;
    
    private Long id;
    
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @NotEmpty(message = "分类别名不能为空")
    private String aliasName;

}
