package com.scofevil.test.springioc;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {

    @AfterReturning(returning = "rvt", pointcut = "execution(*com.scofevil.test.springioc.impl.*.*(..))")
    public void log(Object rvt) {
        System.out.println("获取目标方法返回值 :" + rvt);
        System.out.println("模拟记录日志功能 ...");
    }

}
