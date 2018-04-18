package com.studyinghome.myblog.service.impl;

import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.exception.CategoryException;
import com.studyinghome.myblog.helper.CategoryConvertUtil;
import com.studyinghome.myblog.mapper.CategoryMapper;
import com.studyinghome.myblog.model.dto.CategoryDTO;
import com.studyinghome.myblog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.studyinghome.myblog.enums.CategoryExceptionEnum.NOT_FOUND_CATEGORY;

/**
 * ${文章分类操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加/修改分类
     *
     * @param categoryDTO
     * @return
     */
    @Transactional
    @Override
    public Result<?> addCategory(CategoryDTO categoryDTO) {
        Assert.notNull(categoryDTO,"参数错误:categoryDTO is null");

        if(categoryDTO.getId() == null) {//添加分类
            Category category = CategoryConvertUtil.categoryDTO2Category(categoryDTO, null);
            long now = System.currentTimeMillis();
            category.setCreateTime(now);
            category.setCreateUser(categoryDTO.getUpdateUser());
            category.setUpdateTime(now);
            int row = categoryMapper.save(category);
            return row > 0 ? Result.success("添加成功", category) : Result.fail("添加失败");
        }
        Category category = categoryMapper.findById(categoryDTO.getId());
        if(category == null) {
            throw new CategoryException(NOT_FOUND_CATEGORY);
        }
        //修改分类
        CategoryConvertUtil.categoryDTO2Category(categoryDTO, category);
        long now = System.currentTimeMillis();
        category.setUpdateTime(now);
        int row = categoryMapper.update(category);
        return row > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    //获取当前用户所有分类
    @Override
    public List<Category> getCategorys(Long userId) {
        return categoryMapper.findByUserId(userId);
    }

}
