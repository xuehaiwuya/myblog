package com.studyinghome.myblog.service;

import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.CategoryDTO;

import java.util.List;

/**
 * ${文章分类操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
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
