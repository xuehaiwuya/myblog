package com.studyinghome.myblog.service;

import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.vo.ResourceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public interface ResourceService {

    /**
     * 获取当前用户所有资源
     * @param userId
     * @return
     */
    List<ResourceVO> getAllResource(long userId);

    /**
     * 添加用户资源
     * @param request
     * @param user
     * @return
     */
    Result<List<ResourceVO>> saveResource(HttpServletRequest request, IUser user);

}
