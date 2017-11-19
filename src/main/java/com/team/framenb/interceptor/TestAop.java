package com.team.framenb.interceptor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author haohao
 * @create 2017/11/20 上午12:42
 **/
@Aspect
@Component
public class TestAop {

    private Logger logger = LoggerFactory.getLogger(TestAop.class);

    @Pointcut("@annotation(com.team.framenb.annotation.AopAnnotation)")
    public void printRequestParams(){}

    @Before("printRequestParams()")
    public void before(){
        logger.info("哈哈哈  你被拦截了");
    }


    @After("printRequestParams()")
    public void after(){
        logger.info("哈哈哈  放过你了");
    }
}
