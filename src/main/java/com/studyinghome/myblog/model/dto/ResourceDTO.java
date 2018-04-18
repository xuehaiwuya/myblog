package com.studyinghome.myblog.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.studyinghome.myblog.common.bean.BaseDTO;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class ResourceDTO extends BaseDTO {

    private static final long serialVersionUID = 3826737058144905178L;
    
    private String url;

}
