package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Mapper
public interface SysResourceMapper {

    int saveList(List<SysResource> list);

    int delete(Long id);

    int update(SysResource e);

    SysResource findById(Long id);

    List<SysResource> findAll();

    List<SysResource> findByUserId(long userId);
}
