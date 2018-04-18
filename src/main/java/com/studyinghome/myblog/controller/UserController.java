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
 * @author tt
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        IUser user = (IUser)request.getSession().getAttribute(UserConstants.SESSION_USER);
        if(user != null) {
            mv.setViewName("redirect:/admin/article/myList");
            return mv;
        }
        mv.setViewName("admin/user/login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<?> doLogin(HttpServletRequest request, @Valid UserDTO userDto, BindingResult result) {
        if(result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        return userService.userLogin(userDto, request);
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result<?> logout(HttpServletRequest request) {
        return userService.logout(request);
    }

}
