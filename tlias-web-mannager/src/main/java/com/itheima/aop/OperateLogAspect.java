package com.itheima.aop;

import com.itheima.pojo.OprerateLog;
import com.itheima.service.OperateLogService;
import com.itheima.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class OperateLogAspect {
    @Autowired
    private OperateLogService operateLogService;
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object operateLog(ProceedingJoinPoint pjp) throws Throwable {
        //0.获取程序执行的开始时间
        long begin = System.currentTimeMillis();
        //1.获取谁操作的功能 用户id
        String token = request.getHeader("token");
        Integer operateEmpId = (Integer) JwtUtils.parseJWT(token).get("id");
        //2.获取操作时间
        LocalDate operateTime = LocalDate.now();
        //3.获取操作类名
        String className = pjp.getTarget().getClass().toString();

        //4.获取操作方法名
        String methodName = pjp.getSignature().getName();

        //5.获取操作方法参数
        String methodParams = Arrays.toString(pjp.getArgs());
        //6.调用目标对象的目标方法
        Object result = pjp.proceed();
        //7.获取操作方法返回值(直接使用result返回的结果即可)
        String returnValue = result.toString();
        //8 获取程序的结束时间
        long end = System.currentTimeMillis();
        //8.1获取操作耗时 结束时间-开始时间
        long costTime = end - begin;
        //9.将以上数据封装到OperateLog对象中
        OprerateLog oprerateLog = new OprerateLog(null, operateEmpId, operateTime, className, methodName, methodParams, returnValue, costTime, null);
        operateLogService.inserLog(oprerateLog);
        //10.返回目标对象的方法的返回值
        return result;
    }
}
