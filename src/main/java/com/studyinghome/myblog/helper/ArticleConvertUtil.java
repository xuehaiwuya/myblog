package com.studyinghome.myblog.helper;

import com.studyinghome.myblog.entity.Article;
import com.studyinghome.myblog.common.util.DozerUtil;
import com.studyinghome.myblog.model.dto.ArticleDTO;
import com.studyinghome.myblog.model.vo.ArticleVO;

import java.util.Date;

/**
 * @author tt
 */
public final class ArticleConvertUtil {

    public static Article articleDTO2Article(ArticleDTO articleDTO, Article article) {
        if(article == null) {
            article = new Article();
        }
        if(articleDTO == null) {
            return article;
        }
        DozerUtil.map(articleDTO, article);
        if (articleDTO.getCreateTime() != null) {
            article.setCreateTime(articleDTO.getCreateTime().getTime());
        }
        return article;
    }

    public static ArticleVO article2ArticleVO(Article article) {
        ArticleVO vo = new ArticleVO();
        if(article == null) {
            return vo;
        }
        DozerUtil.map(article, vo);
        if (article.getCreateTime() != null) {
            vo.setCreateTime(new Date(article.getCreateTime()));
        }
        return vo;
    }

}
