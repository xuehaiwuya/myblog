package com.studyinghome.myblog.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.studyinghome.myblog.Application;
import com.studyinghome.myblog.entity.SysParam;
import com.studyinghome.myblog.mapper.SysParamMapper;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class TestSysParamMapper {
    
    @Resource
    private SysParamMapper sysParamMapper;
    
    @Rollback(true)
    @Test
    public void testInsertSysParam() throws Exception {
        SysParam param = new SysParam();
        long now = System.currentTimeMillis();
        param.setCreateTime(now);
        param.setCreateUser(0L);
        param.setParamName("aa");
        param.setParamValue("123");
        param.setUpdateUser(0L);
        param.setUpdateTime(now);
        int row = sysParamMapper.save(param);
        Assert.assertEquals(1, row);
        log.debug("ok...");
    }

}
