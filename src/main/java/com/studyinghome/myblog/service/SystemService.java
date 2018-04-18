package com.studyinghome.myblog.service;

import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.SysParamDTO;
import com.studyinghome.myblog.model.vo.SysParamVO;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public interface SystemService {

    /**
     * 获取所有系统参数
     * @return
     */
    SysParamVO getAllSysParam();

    /**
     * 添加参数
     * @param sysParamDTO
     * @param user
     * @return
     */
    Result<?> save(SysParamDTO sysParamDTO, IUser user);
}
