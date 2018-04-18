package com.studyinghome.myblog.service;

import com.studyinghome.myblog.model.query.ArticleQuery;
import com.studyinghome.myblog.model.vo.ArticleVO;

import java.util.List;

/**
 * ${博客文章操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public interface BlogService {



    /**
     * 查询用户all article
     * @param articleQuery
     * @return
     */
    List<ArticleVO> getUserArticle(ArticleQuery articleQuery);

    /**
     * 根据fixedLink获取article
     * @param fixedLink
     * @return
     */
    ArticleVO getArticle(String fixedLink);

    /**
     * 更新article pv
     * @param articleId
     * @return
     */
    int updateArticlePV(Long articleId);

}
