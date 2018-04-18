package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.SysResource;
import com.studyinghome.myblog.model.dto.ResourceDTO;
import com.studyinghome.myblog.model.vo.ResourceVO;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public final class SysResourceConvertUtil {


    public static ResourceVO sysResource2ResourceVO(SysResource sysResource, ResourceVO resourceVO) {
        Assert.notNull(sysResource,"sysResource is null");
        if(resourceVO == null) {
            resourceVO = new ResourceVO();
        }
        resourceVO.setUrl(sysResource.getUrl());
        return resourceVO;
    }


    public static SysResource resourceDTO2SysResource(ResourceDTO resourceDTO, SysResource sysResource) {
        Assert.notNull(resourceDTO,"resourceDto is null");
        if(sysResource == null) {
            sysResource = new SysResource();
        }
        sysResource.setUrl(resourceDTO.getUrl());
        sysResource.setCreateUser(resourceDTO.getUpdateUser());
        return sysResource;
    }

    public static List<ResourceVO> stringList2ResourceVO(List<String> data) {
        if(data == null) {
            return Collections.emptyList();
        }
        List<ResourceVO> list = new ArrayList<>(data.size());
        for (String url : data) {
            list.add(new ResourceVO(url));
        }
        return list;
    }
}
