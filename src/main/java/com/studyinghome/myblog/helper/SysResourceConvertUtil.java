package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.SysResource;
import com.studyinghome.myblog.model.dto.ResourceDTO;
import com.studyinghome.myblog.model.vo.ResourceVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tt
 */
public final class SysResourceConvertUtil {


    public static ResourceVO sysResource2ResourceVO(SysResource sysResource, ResourceVO resourceVO) {
        if(sysResource == null) {
            throw new IllegalArgumentException("sysResource is null");
        }
        if(resourceVO == null) {
            resourceVO = new ResourceVO();
        }
        resourceVO.setUrl(sysResource.getUrl());
        return resourceVO;
    }


    public static SysResource resourceDTO2SysResource(ResourceDTO resourceDTO, SysResource sysResource) {
        if(resourceDTO == null) {
            throw new IllegalArgumentException("resourceDto is null");
        }
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
