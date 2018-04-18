package com.studyinghome.myblog.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.studyinghome.myblog.Application;
import com.studyinghome.myblog.common.Result;
import com.studyinghome.myblog.model.dto.UserDTO;
import com.studyinghome.myblog.service.UserService;

import javax.annotation.Resource;

/**
 * @author tt
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class TestUserService {

    @Resource
    private UserService userService;

    @Rollback(true)
    @Test
    public void testSaveUser() throws Exception {
        UserDTO e = new UserDTO();
        e.setUsername("admin");
        e.setPassword("123456");
        e.setNickName("admin");
        Result<?> result = userService.saveUser(e);
        Assert.assertEquals(0, result.getCode());
    }
}
