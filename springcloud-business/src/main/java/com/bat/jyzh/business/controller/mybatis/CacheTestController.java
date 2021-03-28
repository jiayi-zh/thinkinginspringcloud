package com.bat.jyzh.business.controller.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.jyzh.business.mybatis.dao.UserDao;
import com.bat.jyzh.business.mybatis.entity.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mybatis 一级缓存和二级缓存测试
 *
 * @author ZhengYu
 * @version 1.0 2021/3/28 20:26
 **/
@Slf4j
@RestController
@RequestMapping("/mybatis")
public class CacheTestController implements ApplicationContextAware {

    @Autowired
    private UserDao userDao;

    private ApplicationContext applicationContext;

    /**
     * 二级缓存测试
     *
     * @author ZhengYu
     */
    @GetMapping(value = "/cache")
    public void generalCRUDTest() {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("jy-zh");
        userPO.setSex((byte) 1);
        userDao.insertSelective(userPO);

        UserPO user1 = userDao.selectByPrimaryKey(1L);
        UserPO user2 = userDao.selectByPrimaryKey(1L);
        UserPO user3 = userDao.selectByPrimaryKey(1L);
        log.info("query --> user1:{} user2:{} user3:{}", JSONObject.toJSONString(user1), JSONObject.toJSONString(user2), JSONObject.toJSONString(user3));

        userDao.deleteByPrimaryKey(1L);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
