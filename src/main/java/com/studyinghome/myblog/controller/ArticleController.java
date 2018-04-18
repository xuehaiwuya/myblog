package com.studyinghome.myblog.controller;

import com.github.pagehelper.PageInfo;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.common.util.DateUtil;
import com.studyinghome.myblog.entity.Category;
import com.studyinghome.myblog.model.query.ArticleQuery;
import com.studyinghome.myblog.model.vo.ArticleVO;
import com.studyinghome.myblog.service.BlogService;
import com.studyinghome.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ${博客页面展示操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    long defaultCreateUser = 2;

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    //获取所有博客文章
    @RequestMapping(value = "/list")
    public ModelAndView postList(ArticleQuery articleQuery) {
        ModelAndView mv = new ModelAndView();
        articleQuery.setCreateUser(defaultCreateUser);
        List<ArticleVO> list = blogService.getUserArticle(articleQuery);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(list);
        mv.addObject("page", pageInfo);
        mv.setViewName("article/list");
        return mv;
    }

    //通过fixedLink获取文章
    @RequestMapping(value = "/{fixedLink}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("fixedLink") String fixedLink) {
        ModelAndView mv = new ModelAndView();
        ArticleVO articleVO = blogService.getArticle(fixedLink);
        if(articleVO == null) {
            return null;
        }
        mv.addObject("id", articleVO.getId());
        mv.addObject("atitle", articleVO.getTitle());
        mv.addObject("createUser", articleVO.getCreateUser());
        mv.addObject("createUserName", articleVO.getCreateUserName());
        mv.addObject("articleId", articleVO.getId());
        mv.addObject("desc", articleVO.getDesc());
        mv.addObject("html", articleVO.getHtml());
        mv.addObject("time", DateUtil.date2String(articleVO.getCreateTime(), DateUtil.YYYY_MM_DD));
        mv.addObject("pv", articleVO.getPv());
        mv.setViewName("article/detail");
        return mv;
    }

    //获取分类列表
    @GetMapping("/categorys")
    @ResponseBody
    public Result<?> categorys() {
        List<Category> categorys = categoryService.getCategorys(defaultCreateUser);
        return Result.success("", categorys);
    }

    //通过文章id获取文章详情
    @GetMapping("/pv/{articleId}")
    @ResponseBody
    public Result<?> pv(@PathVariable("articleId") Long articleId) {
        blogService.updateArticlePV(articleId);
        return Result.success("ok");
    }

    //网页导航栏数据
    @GetMapping("/sidebar")
    public ModelAndView sidebar() {
    	ModelAndView mv = new ModelAndView("/article/_sidebar");
    	getCategorys(mv, defaultCreateUser);
        
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setCreateUser(defaultCreateUser);
        articleQuery.setPageSize(5);
        List<ArticleVO> top5 = blogService.getUserArticle(articleQuery);
        mv.addObject("top5", top5);
        
        return mv;
    }

    //网页的头部数据
    @GetMapping("/header")
    public ModelAndView header() {
    	ModelAndView mv = new ModelAndView("/article/_header");
    	getCategorys(mv, defaultCreateUser);
    	return mv;
    }

    //获取网页的导航(文章的分类)
    private void getCategorys(ModelAndView mv, Long createUser) {
    	List<Category> categorys = categoryService.getCategorys(defaultCreateUser);
        mv.addObject("categorys", categorys);
    }

}
