package com.studyinghome.myblog.model.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.studyinghome.myblog.common.bean.BaseQuery;

/**
 * ${显示文章字段}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class ArticleQuery extends BaseQuery {

    private Long createUser;//创建文章用户id
    private Integer isShow;
    private String title;
    private String content;
    private Long categoryId;
    private String tags;

}
