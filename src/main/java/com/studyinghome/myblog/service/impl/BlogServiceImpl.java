package com.studyinghome.myblog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.studyinghome.myblog.entity.Article;
import com.studyinghome.myblog.enums.ArticleStatusEnum;
import com.studyinghome.myblog.helper.ArticleConvertUtil;
import com.studyinghome.myblog.mapper.ArticleMapper;
import com.studyinghome.myblog.model.query.ArticleQuery;
import com.studyinghome.myblog.model.vo.ArticleVO;
import com.studyinghome.myblog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author tt
 */
@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVO> getUserArticle(ArticleQuery articleQuery) {
        Long userId = articleQuery.getCreateUser();
        log.debug("userId:{}", userId);
        Assert.notNull(userId, "userId must not be null");
        PageHelper.startPage(articleQuery.getPageNum(), articleQuery.getPageSize());
        Page<Article> articles = (Page<Article>) articleMapper.findAll(articleQuery, ArticleStatusEnum.SHOW.getKey());
        Page<ArticleVO> page = new Page<>(articleQuery.getPageNum(), articleQuery.getPageSize());
        page.setTotal(articles.getTotal());
        for(Article article : articles) {
            page.add(ArticleConvertUtil.article2ArticleVO(article));
        }
        return page;
    }

    @Override
    public ArticleVO getArticle(String fixedLink) {
        Article article = articleMapper.findByFixedLink(fixedLink);
        return ArticleConvertUtil.article2ArticleVO(article);
    }

    @Override
    public int updateArticlePV(Long articleId) {
    	if (articleId == null || articleId <= 0) {
			log.warn("articleId is null or lte 0");
			return 1;
		}
        articleMapper.updatePv(articleId);
        return 0;
    }

}
