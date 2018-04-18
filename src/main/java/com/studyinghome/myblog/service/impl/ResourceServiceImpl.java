package com.studyinghome.myblog.service.impl;

import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.util.UploaderUtil;
import com.studyinghome.myblog.component.LocalCache;
import com.studyinghome.myblog.entity.SysResource;
import com.studyinghome.myblog.helper.SysResourceConvertUtil;
import com.studyinghome.myblog.mapper.SysResourceMapper;
import com.studyinghome.myblog.model.vo.ResourceVO;
import com.studyinghome.myblog.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tt
 */
@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<ResourceVO> getAllResource(long userId) {
        List<SysResource> sysResourceList = sysResourceMapper.findByUserId(userId);
        if(sysResourceList == null || sysResourceList.isEmpty()) {
            return Collections.emptyList();
        }
        List<ResourceVO> list = new ArrayList<>(sysResourceList.size());
        for(SysResource sysResource : sysResourceList) {
            list.add(SysResourceConvertUtil.sysResource2ResourceVO(sysResource, null));
        }
        return list;
    }

    @Transactional
    @Override
    public Result<List<ResourceVO>> saveResource(HttpServletRequest request, IUser user) {
        String basePath = LocalCache.getValue("upload_url");
        log.info("====>basePath:" + basePath);
        UploaderUtil.UploadResult result = UploaderUtil.uploader(request, basePath, "file", "/upload", null, 10 * 1024);
        if(!"0".equals(result.getCode())) {
            List<ResourceVO> list = Collections.emptyList();
            return Result.fail(result.getMsg(), list);
        }
        List<SysResource> sysResources = new ArrayList<>();
        for (String url : result.getData()) {
            SysResource sysResource = new SysResource();
            sysResource.setCreateUser(user.getId());
            sysResource.setCreateTime(System.currentTimeMillis());
            sysResource.setUrl(url);
            sysResources.add(sysResource);
        }
        sysResourceMapper.saveList(sysResources);
        return Result.success("", SysResourceConvertUtil.stringList2ResourceVO(result.getData()));
    }
}
