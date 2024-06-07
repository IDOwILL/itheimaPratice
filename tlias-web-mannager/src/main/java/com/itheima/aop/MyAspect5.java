package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 哪些方法会加入通知?
 * 1.能说出切入点表达式完整语法 exection(修饰符 返回值类 包名.类名.方法名(参数类型))
 * 2.能说出通配符的含义   .. 可以0或多个任意字符 * 仅一个单个字符
 * 3.能看懂切入点表达式
 * 4.能否自己写切入点表达式（需求：省略修饰符 任意返回值类型 方法名以getBy开头 任意参数）
 */
@Slf4j
@Component
//@Aspect
public class MyAspect5 {


    @Before("execution(* com.itheima.service.DeptService.getBy*(..))")
    public void before(){
        log.info("148最牛b............");
    }

    //前置通知 匹配 delete方法 为方法进行增强
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

    //匹配到DeptServiceImpl中所有的方法 进行增强
    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void before4(){
        log.info("MyAspect5 -> before4 ...");
    }

    //匹配到com.itheima.service.impl包下的所有类中所有的方法 进行增强
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before5(){
        log.info("MyAspect5 -> before5 ...");
    }

    //匹配到com.itheima.service.impl.DeptServiceImpl类下del开头的方法名称
    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.del*(..))")
    public void before6(){
        log.info("MyAspect5 -> before6 ...");
    }

    //匹配到com.(匹配任意多层的包)
    @Before("execution(* com..service.*.*(..))")
    public void before7(){
        log.info("MyAspect5 -> before7 ...");
    }

    //什么都匹配 一定不要这么用 一般情况推荐 尽量缩小范围
    /*@Before("execution(* *(..))")
    public void before8(){
        log.info("MyAspect5 -> before8 ...");
    }*/

    //匹配list 或 save 进行功能增强
    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.list()) ||  " +
            "execution(* com.itheima.service.impl.DeptServiceImpl.save(*))")
    public void before9(){
        log.info("MyAspect5 -> before9 ...");
    }

    //匹配DeptService接口 会对接口的所有实现类所有方法任意参数进行功能增强
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
