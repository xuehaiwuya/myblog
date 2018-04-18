package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.common.util.DozerUtil;
import com.studyinghome.myblog.model.dto.CategoryDTO;

/**
 * ${分类工具}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public final class CategoryConvertUtil {

    public static Category categoryDTO2Category(CategoryDTO categoryDto, Category category) {
        if(category == null) {
            category = new Category();
        }
        DozerUtil.map(categoryDto, category);
        return category;
    }

}
