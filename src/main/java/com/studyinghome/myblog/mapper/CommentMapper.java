package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tt
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
