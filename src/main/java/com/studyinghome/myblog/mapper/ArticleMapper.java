package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.studyinghome.myblog.model.query.ArticleQuery;

import java.util.List;

/**
 * @author tt
 */
@Mapper
public interface ArticleMapper {
    
    int save(Article e);
    
    int delete(Long id);
    
    int update(Article e);
    
    Article findById(Long id);
    
    List<Article> findAll(@Param("q") ArticleQuery articleQuery, @Param("status") int status);

    Article findByFixedLink(String fixedLink);

    int updatePv(Long id);
}
