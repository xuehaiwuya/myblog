package com.studyinghome.myblog.service;

import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.CategoryDTO;

import java.util.List;

/**
 * @author tt
 */
public interface CategoryService {
    
    /**
     * 添加分类
     * @param categoryDTO
     * @return
     */
    Result<?> addCategory(CategoryDTO categoryDTO);

    /**
     * 获取用户分类
     * @param userId
     * @return
     */
    List<Category> getCategorys(Long userId);

}
