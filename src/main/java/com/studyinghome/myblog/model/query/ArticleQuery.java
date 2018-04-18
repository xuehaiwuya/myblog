package com.studyinghome.myblog.model.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.studyinghome.myblog.common.bean.BaseQuery;

/**
 * @author tt
 */
@Setter
@Getter
@ToString
public class ArticleQuery extends BaseQuery {

    private Long createUser;
    private Integer isShow;
    private String title;
    private String content;
    private Long categoryId;
    private String tags;

}
