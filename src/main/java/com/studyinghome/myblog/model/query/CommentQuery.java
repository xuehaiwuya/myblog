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
public class CommentQuery extends BaseQuery {

    private Long articleId;

}
