package com.bat.jyzh.business.controller.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.bat.jyzh.business.mybatis.dao.UserDao;
import com.bat.jyzh.business.mybatis.entity.UserPO;
import com.bat.jyzh.common.entity.resp.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多数据源测试
 *
 * @author ZhengYu
 * @version 1.0 2021/3/10 11:28
 **/
@Slf4j
@RestController
@RequestMapping("/mybatis/transaction")
public class TransactionController implements ApplicationContextAware {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSourceTransactionManager source1DataSourceTransactionManager;

    @Autowired
    private DataSourceTransactionManager source2DataSourceTransactionManager;

    private ApplicationContext applicationContext;

    /**
     * 声明式事务
     */
    @Transactional(rollbackFor = Exception.class, transactionManager = "source1DataSourceTransactionManager")
    @GetMapping("declarative")
    public CommonResult<?> declarativeTransaction() {
        UserPO user = new UserPO();
        user.setName(String.format("zy%d", COUNTER.getAndIncrement()));
        userDao.insert(user);
        if (new Random().nextBoolean()) {
            log.error("用户 {} 入库即将失败", JSONObject.toJSONString(user));
            throw new RuntimeException("报错");
        }
        return CommonResult.buildCommonResult(0, "success");
    }

    /**
     * 编程式事务
     */
    @GetMapping("programmatic")
    public CommonResult<?> programmaticTransaction() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = source1DataSourceTransactionManager.getTransaction(defaultTransactionDefinition);

        UserPO user = new UserPO();
        user.setName(String.format("zy%d", COUNTER.getAndIncrement()));
        userDao.insert(user);
        if (new Random().nextBoolean()) {
            log.error("用户 {} 入库即将失败", JSONObject.toJSONString(user));
            source1DataSourceTransactionManager.rollback(transactionStatus);
            throw new RuntimeException("报错");
        }
        source1DataSourceTransactionManager.commit(transactionStatus);
        return CommonResult.buildCommonResult(0, "success");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
