package com.studyinghome.myblog.model.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.studyinghome.myblog.common.bean.BaseQuery;

/**
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Setter
@Getter
@ToString
public class CommentQuery extends BaseQuery {

    private Long articleId;

}
