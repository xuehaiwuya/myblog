package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.Comment;
import com.studyinghome.myblog.common.util.DateUtil;
import com.studyinghome.myblog.model.dto.CommentDTO;
import com.studyinghome.myblog.model.vo.CommentVO;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * ${评论工具}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public class CommentConvertUtil {


    public static CommentVO comment2CommentVO(Comment c, CommentVO vo) {
        if (vo == null) {
            vo = new CommentVO();
        }

        Assert.notNull(c,"comment must not be null");
        vo.setId(c.getId());
        vo.setContent(c.getContent());
        vo.setCreateTime(DateUtil.date2String(new Date(c.getCreateTime()), "yyyy-MM-dd HH:mm"));
        vo.setNickName(c.getNickName());
        vo.setSite(c.getSite());
        vo.setToNickName(c.getToNickName());
        return vo;
    }

    public static Comment commentDTO2Comment(CommentDTO commentDTO, Comment c) {

        if (c == null) {
            c = new Comment();
        }

        Assert.notNull(commentDTO,"commentDTO must not be null");
        c.setSite(commentDTO.getSite());
        c.setNickName(commentDTO.getNickName());
        c.setCommentObj(commentDTO.getArticleId());
        c.setContent(commentDTO.getContent());
        c.setEmail(commentDTO.getEmail());
        c.setParentId(commentDTO.getParentId());
        return c;
    }
}
