package com.studyinghome.myblog.service;

import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.vo.ResourceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tt
 */
public interface ResourceService {

    List<ResourceVO> getAllResource(long userId);

    Result<List<ResourceVO>> saveResource(HttpServletRequest request, IUser user);

}
