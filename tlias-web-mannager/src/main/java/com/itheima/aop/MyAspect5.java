package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 哪些方法会加入通知?
 * 1.能说出切入点表达式完整语法
 * 2.能说出通配符的含义
 * 3.能看懂切入点表达式
 */
@Slf4j
@Component
//@Aspect
public class MyAspect5 {

    //前置通知
    @Before("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    public void before1(){
        log.info("MyAspect5 -> before1 ...");
    }

    @Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    public void before2(){
        log.info("MyAspect5 -> before2 ...");
    }

    @Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(*))")
    public void before3(){
        log.info("MyAspect5 -> before3 ...");
    }


    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void before4(){
        log.info("MyAspect5 -> before4 ...");
    }

    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before5(){
        log.info("MyAspect5 -> before5 ...");
    }

    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.del*(..))")
    public void before6(){
        log.info("MyAspect5 -> before6 ...");
    }

    @Before("execution(* com..service.*.*(..))")
    public void before7(){
        log.info("MyAspect5 -> before7 ...");
    }

    /*@Before("execution(* *(..))")
    public void before8(){
        log.info("MyAspect5 -> before8 ...");
    }*/

    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.list()) ||  " +
            "execution(* com.itheima.service.impl.DeptServiceImpl.save(*))")
    public void before9(){
        log.info("MyAspect5 -> before9 ...");
    }

    @Before("execution(* com.itheima.service.DeptService.*(..))")
    public void before10(){
        log.info("MyAspect5 -> before10 ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after(){
        log.info("MyAspect5 -> after11 ...");
    }

}
