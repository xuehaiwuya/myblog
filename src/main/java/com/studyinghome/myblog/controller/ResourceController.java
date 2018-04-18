package com.studyinghome.myblog.controller;

import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.common.annotation.Security;
import com.studyinghome.myblog.common.security.IUser;
import com.studyinghome.myblog.common.security.SessionUserContext;
import com.studyinghome.myblog.model.vo.ResourceVO;
import com.studyinghome.myblog.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tt
 */
@Slf4j
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Security
    @RequestMapping(value = "/getPic")
    @ResponseBody
    public Result<?> getPic() {
        IUser user = SessionUserContext.get();
        List<ResourceVO> list = resourceService.getAllResource(user.getId());
        return Result.success("ok", list);
    }

    @Security
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Result<?> upload(HttpServletRequest request) {
        log.debug("==== upload start ====");
        IUser user = SessionUserContext.get();
        return resourceService.saveResource(request, user);
    }


}
