package com.scofevil.test;

public class TestSynchonized {
    public static void main(String[] args) {
        final TestObject to = new TestObject();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    to.doSomething("thread-1");
                }
            }
        }, "thread-1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    to.doSomething("thread-2");
                }
            }
        }, "thread-2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        to.setCount(3);
    }
}
