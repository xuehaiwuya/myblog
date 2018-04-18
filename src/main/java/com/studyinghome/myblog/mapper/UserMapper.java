package com.studyinghome.myblog.mapper;

import com.studyinghome.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${用户操作}
 *
 * @author panxiang
 * @create 2018-04-17 22:07
 */
@Mapper
public interface UserMapper {

    //添加用户
    int save(User user);

    //删除用户
    int delete(Long id);

    //通过用户名更新用户信息
    int updateByUsername(User user);

    //通过用户名获取用户信息
    User findByUsername(String username);

    //获取所有用户信息
    List<User> findAll();

}
