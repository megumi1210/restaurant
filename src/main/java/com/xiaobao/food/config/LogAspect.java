package com.xiaobao.food.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;


@Slf4j
@Component
@EnableAspectJAutoProxy
public class LogAspect {


    private static String[] types = {"java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float"};
    private static ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(* com.xiaobao.food.controller.RestaurantController.*(..))")
    public void pointcut(){}


    @Before("pointcut()")
    public void before(JoinPoint joinPoint){

        startTime.set(System.currentTimeMillis());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String info = String.format("\n =======> 请求信息:   %s",getMethodInfo(joinPoint));
        log.info(info);

    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning(){
      long costTime =  System.currentTimeMillis() - startTime.get();
      log.info("耗费时间： " + costTime + "ms");
    }



    private String getMethodInfo(JoinPoint point) {
        String className = point.getSignature().getDeclaringType().getSimpleName();
        String methodName = point.getSignature().getName();
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();

        return className+"-"+methodName+"-"+ Arrays.toString(parameterNames);

    }


}
