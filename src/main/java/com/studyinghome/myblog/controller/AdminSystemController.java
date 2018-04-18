package com.studyinghome.myblog.controller;

import com.studyinghome.myblog.common.annotation.Security;
import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.security.SessionUserContext;
import com.studyinghome.myblog.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.SysParamDTO;
import com.studyinghome.myblog.model.vo.SysParamVO;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * ${后台系统设置}
 *
 * @author panxiang
 * @create 2018-04-17 22:15
 */
@Controller
@RequestMapping(value = "/admin/system")
public class AdminSystemController {

    @Resource
    private SystemService systemService;

    @Security
    @RequestMapping(value = "/setup")
    public ModelAndView setup() {
        ModelAndView mv = new ModelAndView("admin/system/setup");
        SysParamVO sysParamVO = systemService.getAllSysParam();
        mv.addObject("vo", sysParamVO);
        return mv;
    }

    @Security
    @PostMapping(value = "/setupSave")
    @ResponseBody
    public Result<?> setupSave(@Valid SysParamDTO sysParamDTO, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        IUser user = SessionUserContext.get();
        return systemService.save(sysParamDTO, user);
    }

}
