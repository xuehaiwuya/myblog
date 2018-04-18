package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.SysParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Mapper
public interface SysParamMapper {
    
    int save(SysParam e);

    int delete(String paramName);

    int update(SysParam e);

    SysParam findByName(String paramName);

    List<SysParam> findAll();

}
