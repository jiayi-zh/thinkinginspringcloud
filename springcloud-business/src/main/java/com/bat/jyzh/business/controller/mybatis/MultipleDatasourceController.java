package com.bat.jyzh.business.controller.mybatis;

import com.bat.jyzh.business.mybatis.dao.UserDao;
import com.bat.jyzh.common.entity.resp.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 多数据源测试
 *
 * @author ZhengYu
 * @version 1.0 2021/3/10 11:28
 **/
@Slf4j
@RestController
@RequestMapping("/mybatis/multiple/datasource")
public class MultipleDatasourceController implements ApplicationContextAware {

    @Autowired
    private UserDao userDao;

    private ApplicationContext applicationContext;

    @Transactional(rollbackFor = Exception.class, transactionManager = "faceAlgorithmAdapterDataSourceTransactionManager")
    @GetMapping("test")
    public CommonResult<?> testMultipleDatasource() {
        if (log.isDebugEnabled()) {
            Map<String, UserDao> userDaoBeans = applicationContext.getBeansOfType(UserDao.class);
            log.info("UserDao 实现: {}", userDaoBeans);
        }

        return CommonResult.buildCommonResult(0, "success");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
