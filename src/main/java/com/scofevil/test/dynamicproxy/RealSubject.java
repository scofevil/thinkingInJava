package com.scofevil.test.dynamicproxy;

public class RealSubject implements Subject {

    public void doSomething() {
        System.out.println("call doSomething");
    }

    public void doSomething1() {
        System.out.println("call doSomething1");
    }

}
