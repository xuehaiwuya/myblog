package com.studyinghome.myblog.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.studyinghome.myblog.common.bean.BaseDTO;

/**
 * @author tt
 */
@Setter
@Getter
@ToString
public class ResourceDTO extends BaseDTO {

    private static final long serialVersionUID = 3826737058144905178L;
    
    private String url;

}
