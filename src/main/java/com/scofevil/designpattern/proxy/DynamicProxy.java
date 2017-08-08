package com.scofevil.designpattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class DynamicProxy implements InvocationHandler {

    private Object source;

    public DynamicProxy(Object source) {
        super();
        this.source = source;
    }

    public static void main(String[] args) throws IOException {
        //只要你传入就可以强转成功
        TestInterface object = (TestInterface) Proxy
                .newProxyInstance(ClassLoader.getSystemClassLoader(),
                        new Class[] { TestInterface.class }, new DynamicProxy(new TestClass()));
        object.method1();
        object.method2();
        object.method3();
        object.toString();
        byte[] classFile = ProxyGenerator
                .generateProxyClass("TestProxy", new Class[] { TestInterface.class });
        File file = new File("TestProxy1.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(classFile);
        fos.flush();
        fos.close();
    }

    public void before() {
        System.out.println("在方法前做一些事情");
    }

    public void after() {
        System.out.println("在方法后做一些事情");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //假设我们切入toString方法，其他其实也是类似的，一般我们这里大部分是针对特定的方法做事情的，通常不会对类的全部方法切入
        //比如我们常用的事务管理器，我们通常配置的就是对save,update,delete等方法才打开事务
        if (method.getName().equals("toString")) {
            before();
        }
        Object result = method.invoke(source, args);
        if (method.getName().equals("toString")) {
            after();
        }
        return result;
    }

    public Object getProxy() {
        return Proxy
                .newProxyInstance(getClass().getClassLoader(), source.getClass().getInterfaces(),
                        this);
    }
}
