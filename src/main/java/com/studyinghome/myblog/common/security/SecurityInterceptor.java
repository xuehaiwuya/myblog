package com.studyinghome.myblog.common.security;

import com.studyinghome.myblog.common.annotation.Security;
import com.studyinghome.myblog.common.constant.UserConstants;
import com.studyinghome.myblog.common.enums.ErrorEnum;
import com.studyinghome.myblog.common.exception.CustomSecurityException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tt
 */
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Security security = handlerMethod.getMethodAnnotation(Security.class);
            if (security == null) {
                return true;
            }
            
            // 需要校验是否登录
            IUser user = (IUser)request.getSession().getAttribute(UserConstants.SESSION_USER);
            if(user == null) {
                throw new CustomSecurityException(ErrorEnum.NOT_LOGIN);
            }
            SessionUserContext.put(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
