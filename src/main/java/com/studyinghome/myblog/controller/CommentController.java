package com.studyinghome.myblog.controller;

import com.github.pagehelper.PageInfo;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.CommentDTO;
import com.studyinghome.myblog.model.query.CommentQuery;
import com.studyinghome.myblog.model.vo.CommentVO;
import com.studyinghome.myblog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * ${评论 controller}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    //通过文章id获取评论
    @RequestMapping(value = "/list/{articleId}")
    @ResponseBody
    public Result<?> list(@PathVariable("articleId") Long articleId,
                          @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false, defaultValue = "10")Integer pageSize) {
        CommentQuery commentQuery = new CommentQuery();
        commentQuery.setArticleId(articleId);
        commentQuery.setPageNum(pageNum);
        commentQuery.setPageSize(pageSize);
        List<CommentVO> list = commentService.getCommentsByArticleId(commentQuery);
        PageInfo<CommentVO> page = new PageInfo<>(list);
        return Result.success("ok", page);
    }

    //添加文章评论
    @PostMapping(value = "/save")
    @ResponseBody
    public Result<?> save(@Valid CommentDTO commentDTO, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        return commentService.save(commentDTO);
    }

}
