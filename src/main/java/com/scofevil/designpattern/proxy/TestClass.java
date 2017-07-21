package com.scofevil.designpattern.proxy;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class TestClass implements TestInterface{
    @Override
    public void method1(){
        System.out.println("TestClass.method1");
    }
    @Override
    public void method2(){
        System.out.println("TestClass.method2");
    }
    @Override
    public void method3(){
        System.out.println("TestClass.method3");
    }
}
