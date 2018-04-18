package com.studyinghome.myblog.service;

import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.CommentDTO;
import com.studyinghome.myblog.model.query.CommentQuery;
import com.studyinghome.myblog.model.vo.CommentVO;

import java.util.List;

/**
 * @author tt
 */
public interface CommentService {

    /**
     * 根据文章id获取评论
     * @param commentQuery
     * @return
     */
    List<CommentVO> getCommentsByArticleId(CommentQuery commentQuery);

    /**
     * 评论文章
     * @param commentDTO
     * @return
     */
    Result<?> save(CommentDTO commentDTO);
}
