package com.studyinghome.myblog.controller;

import com.studyinghome.myblog.common.constant.UserConstants;
import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-18 11:09
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //通过session判断用户是否登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        IUser user = (IUser)request.getSession().getAttribute(UserConstants.SESSION_USER);
        if(user != null) {
            //已经登录则返回用户文章列表
            mv.setViewName("redirect:/admin/article/myList");
            return mv;
        }
        //未登录，返回到登录界面
        mv.setViewName("admin/user/login");
        return mv;
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<?> doLogin(HttpServletRequest request, @Valid UserDTO userDto, BindingResult result) {
        if(result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        return userService.userLogin(userDto, request);
    }

    //退出登录
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result<?> logout(HttpServletRequest request) {
        return userService.logout(request);
    }

}
