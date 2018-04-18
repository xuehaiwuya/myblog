package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.SysParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tt
 */
@Mapper
public interface SysParamMapper {
    
    int save(SysParam e);

    int delete(String paramName);

    int update(SysParam e);

    SysParam findByName(String paramName);

    List<SysParam> findAll();

}
