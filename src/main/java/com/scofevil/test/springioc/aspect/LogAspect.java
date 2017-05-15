package com.scofevil.test.springioc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {

    @Around("execution(* com.scofevil.test.springioc.dao.*.*(..))")
    public void log(ProceedingJoinPoint jp) {
        System.out.println("获取目标方法返回值 :" + jp);
        System.out.println("模拟记录日志功能 ...");
    }

}
