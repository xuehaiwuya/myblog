package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tt
 */
@Mapper
public interface CategoryMapper {
    
    int save(Category e);
    
    int delete(Long id);
    
    int update(Category e);

    Category findById(Long id);
    
    List<Category> findAll();

    List<Category> findByUserId(Long userId);
}
