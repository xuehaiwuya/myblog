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
 * @create 2018-04-17 22:15
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static final String salt = "{2038alkdjfwoieurnvytnlklsjdgalkjdfah#}";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogMapper userLogMapper;

    /**
     * 用户登录
     *
     * @param userDTO
     * @param request
     * @return
     */
    @Override
    public Result<?> userLogin(UserDTO userDTO, HttpServletRequest request) {
        //1.判断传入值是否为空
        if (userDTO == null) {
            log.error("userDo is empty");
            return Result.fail("用户名密码不能为空");
        }
        //2.通过用户名获取用户信息
        User user = userMapper.findByUsername(userDTO.getUsername());
        if (user == null) {
            log.error("user is empty");
            return Result.fail("用户名或密码不正确");
        }
        UserLog userLog = userLogMapper.findByUserId(user.getId());
//      String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword()+salt).getBytes());//加密
        String pwd = userDTO.getPassword();

        //3.对比密码是否相同
        if (!user.getPassword().equals(pwd)) {
            log.error("user password error");
            //登录失败，更新用户登录log日志
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
            //30分钟内连续登录失败3次则禁止登录
            if (System.currentTimeMillis() - userLog.getLoginTime().getTime() < 1000 * 60 * 30 && userLog.getLoginErrorCount() >= 3) {
                return Result.fail("该用户禁止登录，请联系管理员");
            }
            //登录成功，更新登录次数，重置失败次数
            userLog.setLoginStat(userLog.getLoginStat() + 1);
            userLog.setLoginTime(new Date());
            userLog.setLoginErrorCount(0);
            userLogMapper.update(userLog);
        } else {//登录成功,保存登录日志
            userLogMapper.save(new UserLog(0L, user.getId(), new Date(), 1, 0));
        }
        //添加session
        request.getSession().setAttribute(UserConstants.SESSION_USER, user);
        return Result.success("登录成功");
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @Override
    public Result<?> logout(HttpServletRequest request) {
        //删除session
        request.getSession().removeAttribute(UserConstants.SESSION_USER);
        return Result.success("退出成功");
    }

    /**
     * 更新用户信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public Result<?> updateUser(UserDTO userDTO) {
        //1.判断传值是否为空
        Assert.notNull(userDTO,"userDTO is null");
        //2.通过用户名获取用户信息
        User user = userMapper.findByUsername(userDTO.getUsername());
        if (user == null) {//用户不存在
            throw new UserException(NOT_FOUND_USER);
        }
        //更新用户信息
//      String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword() + salt).getBytes());
        String pwd = userDTO.getPassword();
        user.setPassword(pwd);
        int i = userMapper.updateByUsername(user);
        return i > 0 ? Result.success("更新成功") : Result.fail("更新失败");
    }

    /**
     * 添加用户
     *
     * @param userDTO
     * @return
     */
    @Override
    public Result<?> saveUser(UserDTO userDTO) {
        Assert.notNull(userDTO, "userDTO must not be null");

//      String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword() + salt).getBytes());
//      userDTO.setPassword(pwd);
        User user = UserConvertUtil.userDTO2User(userDTO, null);
        user.setCreateTime(System.currentTimeMillis());
        int row = userMapper.save(user);
        return row > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }
}
