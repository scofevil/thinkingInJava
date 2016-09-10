package com.scofevil.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object proxied;

    public ProxyHandler(RealSubject real) {
        super();
        this.proxied = real;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在转调具体对象之前，可以执行一些功能处理
        System.out.println("before dosomething");
        //转调具体目标对象的方法
        Object result = method.invoke(proxied, args);
        //在转调具体目标对象之后，可以执行一些功能处理
        System.out.println("after dosomething");
        return result;
    }

}
