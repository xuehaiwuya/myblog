package com.studyinghome.myblog.model.vo;

import com.studyinghome.myblog.common.bean.IResource;
import com.studyinghome.myblog.common.constant.SystemConst;
import lombok.*;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResourceVO implements IResource {


    private static final long serialVersionUID = -2281334849041660486L;

    private String url;

    @Override
    public String getFullUrl() {
        return SystemConst.STATIC_PREFIX + this.getUrl();
    }
}
