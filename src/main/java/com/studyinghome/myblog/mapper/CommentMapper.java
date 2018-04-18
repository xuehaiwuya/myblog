package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${评论 mapper}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Mapper
public interface CommentMapper {

    int save(Comment e);

    int delete(Long id);

    int update(Comment e);

    Comment findById(Long id);

    Comment findByParentId(Long parentId);

    List<Comment> findByCommentObj(Long commentObj);

}
