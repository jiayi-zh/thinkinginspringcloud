package com.bat.jyzh.business.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;

/**
 * {@link org.springframework.boot.ApplicationRunner}
 * {@link org.springframework.boot.CommandLineRunner}
 *
 * 执行过程源码:
 * {@link org.springframework.boot.SpringApplication#callRunners(ApplicationContext, ApplicationArguments)}
 *
 * @author ZhengYu
 * @version 1.0 2021/3/2 18:07
 **/
public class CustomApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
