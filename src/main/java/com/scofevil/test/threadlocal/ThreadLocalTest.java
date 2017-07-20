package com.scofevil.test.threadlocal;

public class ThreadLocalTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DoSomething());
        Thread t2 = new Thread(new DoSomething());
        Thread t3 = new Thread(new DoSomething());
        t1.threadLocals;
        t1.start();
        t2.start();
        t3.start();
    }
}
