package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.common.util.DozerUtil;
import com.studyinghome.myblog.model.dto.CategoryDTO;

/**
 * @author tt
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
