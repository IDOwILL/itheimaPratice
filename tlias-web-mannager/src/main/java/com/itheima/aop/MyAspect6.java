package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 日志注解
 */
@Slf4j
@Component
@Aspect
public class MyAspect6 {

    //前置通知
    @Before("@annotation(com.itheima.anno.Log)")
    public void before(){
        log.info("MyAspect6 -> before ...");
    }

    //后置通知
    @After("@annotation(com.itheima.anno.Log)")
    public void after(){
        log.info("MyAspect6 -> after ...");
    }
    //@annotation在代码比较乱的时候使用
    //execution在代码比较工整的时候使用
}