package com.scofevil.test.dynamicproxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class DynamicProxy {
    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        //Class<?>[] infc = new Class[] { Subject.class ,List.class};
        Class<?>[] infc = RealSubject.class.getInterfaces();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
            infc, new ProxyHandler(real));
        proxySubject.doSomething();
        proxySubject.doSomething1();

        //write proxySubject class binary data to file
        createProxyClassFile();
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
        try {
            FileOutputStream out = new FileOutputStream(name + ".class");
            out.write(data);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
