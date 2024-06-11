package com.itheima.aop;

import com.itheima.pojo.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
public class RecordTimeAccept {
    /**
     * 记录时间
     *
     * @param pjp pjp
     * @return 对象
     * @throws Throwable 可丢弃
     */
    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..) )")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("(end -begin) :{}",(end -begin));
        return result;
    }
}
