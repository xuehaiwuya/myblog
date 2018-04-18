package com.studyinghome.myblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.entity.Comment;
import com.studyinghome.myblog.enums.StatusEnum;
import com.studyinghome.myblog.helper.CommentConvertUtil;
import com.studyinghome.myblog.mapper.CommentMapper;
import com.studyinghome.myblog.model.dto.CommentDTO;
import com.studyinghome.myblog.model.query.CommentQuery;
import com.studyinghome.myblog.model.vo.CommentVO;
import com.studyinghome.myblog.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${评论 service}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过文章id获取评论
     *
     * @param commentQuery
     * @return
     */
    @Override
    public List<CommentVO> getCommentsByArticleId(CommentQuery commentQuery) {
        PageHelper.startPage(commentQuery.getPageNum(), commentQuery.getPageSize());
        List<Comment> list = commentMapper.findByCommentObj(commentQuery.getArticleId());
        Page<Comment> temp = (Page<Comment>) list;
        Page<CommentVO> page = new Page<>(temp.getPageNum(), temp.getPageSize());
        page.setTotal(temp.getTotal());
        for (Comment c : list) {
            page.add(CommentConvertUtil.comment2CommentVO(c, null));
        }
        return page;
    }

    /**
     * 添加评论
     *
     * @param commentDTO
     * @return
     */
    @Override
    public Result<?> save(CommentDTO commentDTO) {
        Assert.notNull(commentDTO, "commentDTO must not be null");
        Comment comment = CommentConvertUtil.commentDTO2Comment(commentDTO, null);
        if (comment.getParentId() != null) {
            Comment parent = commentMapper.findById(comment.getParentId());
            if (parent != null) {
                comment.setToNickName(parent.getNickName());
            }
        }
        comment.setStatus(StatusEnum.OK.getKey());
        comment.setCreateTime(System.currentTimeMillis());
        int row = commentMapper.save(comment);
        return row > 0 ? Result.success("保存成功") : Result.fail("保存失败");
    }

}
