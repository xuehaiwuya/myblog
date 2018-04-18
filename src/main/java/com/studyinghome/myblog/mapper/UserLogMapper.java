package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.UserLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${用户日志操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:07
 */
@Mapper
public interface UserLogMapper {

    //保存用户登录日志
    int save(UserLog userLog);

    //删除用户登录日志
    int delete(Long id);

    //更新用户登录日志
    int update(UserLog userLog);

    //通过用户id获取用户登录日志
    UserLog findByUserId(Long userId);

    //获取所有用户登录日志
    List<UserLog> findAll();

}
