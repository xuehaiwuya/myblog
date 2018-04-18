package com.studyinghome.myblog.service.impl;

import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.common.constant.UserConstants;
import com.studyinghome.myblog.entity.User;
import com.studyinghome.myblog.entity.UserLog;
import com.studyinghome.myblog.exception.UserException;
import com.studyinghome.myblog.helper.UserConvertUtil;
import com.studyinghome.myblog.mapper.UserLogMapper;
import com.studyinghome.myblog.mapper.UserMapper;
import com.studyinghome.myblog.model.dto.UserDTO;
import com.studyinghome.myblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.studyinghome.myblog.enums.UserExceptionEnum.NOT_FOUND_USER;


/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:07
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static final String salt = "{2038alkdjfwoieurnvytnlklsjdgalkjdfah#}";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogMapper userLogMapper;

    //用户登录
    @Override
    public Result<?> userLogin(UserDTO userDTO, HttpServletRequest request) {
        if (userDTO == null) {
            log.error("userDo is empty");
            return Result.fail("用户名密码不能为空");
        }
        User user = userMapper.findByUsername(userDTO.getUsername());
        if (user == null) {
            log.error("user is empty");
            return Result.fail("用户名或密码不正确");
        }
        UserLog userLog = userLogMapper.findByUserId(user.getId());

//        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword()+salt).getBytes());
        String pwd = userDTO.getPassword();

        if (!user.getPassword().equals(pwd)) {
            log.error("user password error");
            if (userLog == null) {
                userLogMapper.save(new UserLog(0L, user.getId(), new Date(), 1, 1));
            } else {
                userLog.setLoginTime(new Date());
                userLog.setLoginErrorCount(userLog.getLoginErrorCount() + 1);
                userLog.setLoginStat(userLog.getLoginStat() + 1);
                userLogMapper.update(userLog);
            }
            return Result.fail("用户名或密码不正确");
        }

        if (userLog != null) {
            if (System.currentTimeMillis() - userLog.getLoginTime().getTime() < 1000 * 60 * 30 && userLog.getLoginErrorCount() >= 3) {
                return Result.fail("该用户禁止登录，请联系管理员");
            }
            userLog.setLoginStat(userLog.getLoginStat() + 1);
            userLog.setLoginTime(new Date());
            userLog.setLoginErrorCount(0);
            userLogMapper.update(userLog);
        } else {
            userLogMapper.save(new UserLog(0L, user.getId(), new Date(), 1, 0));
        }

        request.getSession().setAttribute(UserConstants.SESSION_USER, user);
        return Result.success("登录成功");
    }

    @Override
    public Result<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute(UserConstants.SESSION_USER);
        return Result.success("退出成功");
    }

    @Override
    public Result<?> updateUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("userDTO is null");
        }
        User user = userMapper.findByUsername(userDTO.getUsername());
        if (user == null) {
            throw new UserException(NOT_FOUND_USER);
        }
//        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword() + salt).getBytes());
        String pwd = userDTO.getPassword();
        user.setPassword(pwd);
        int i = userMapper.updateByUsername(user);
        return i > 0 ? Result.success("更新成功") : Result.fail("更新失败");
    }

    @Override
    public Result<?> saveUser(UserDTO userDTO) {
        Assert.notNull(userDTO, "userDTO must not be null");

//        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword() + salt).getBytes());
        String pwd = userDTO.getPassword();
        userDTO.setPassword(pwd);
        User user = UserConvertUtil.userDTO2User(userDTO, null);
        user.setCreateTime(System.currentTimeMillis());
        int row = userMapper.save(user);
        return row > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }
}
