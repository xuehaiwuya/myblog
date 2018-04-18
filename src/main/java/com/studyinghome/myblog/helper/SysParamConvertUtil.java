package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.SysParam;
import com.studyinghome.myblog.model.dto.SysParamDTO;
import org.springframework.util.Assert;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class SysParamConvertUtil {

    public static SysParam sysParamDTO2SysParam(SysParamDTO dto, SysParam param) {
        if (param == null) {
            param = new SysParam();
        }
        Assert.notNull(dto,"sysParamDTO must not be null");
        param.setParamName(dto.getParamName());
        param.setParamValue(dto.getParamValue());
        return param;
    }

}
