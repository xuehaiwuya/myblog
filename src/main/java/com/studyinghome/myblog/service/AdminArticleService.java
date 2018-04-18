package com.studyinghome.myblog.service;

import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.ArticleDTO;
import com.studyinghome.myblog.model.query.ArticleQuery;
import com.studyinghome.myblog.model.vo.ArticleVO;

import java.util.List;

/**
 * ${文章后台操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
public interface AdminArticleService {

    /**
     * 保存article
     * @param articleDTO
     * @return
     */
    Result<?> addOrUpdateArticle(ArticleDTO articleDTO);

    /**
     * 编辑article
     * @param articleId
     * @param user 当前登录用户
     * @return
     */
    Result<ArticleVO> editArticle(Long articleId, IUser user);


    /**
     * 删除article
     * @param articleId
     * @param user
     * @return
     */
    Result<?> deleteArticle(Long articleId, IUser user);

    /**
     * 获取用户所有article
     * @param articleQuery
     * @return
     */
    List<ArticleVO> getUserArticleAll(ArticleQuery articleQuery);
}
