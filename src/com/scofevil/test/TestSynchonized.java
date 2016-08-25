package com.scofevil.test;

public class TestSynchonized {

    static volatile boolean _1 = false;
    static volatile boolean _2 = false;
    static int              a;

    static synchronized void setA() {
        a++;
    }

    public static void main(String[] args) {
        final TestObject to = new TestObject();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000000; i++) {
                    to.doSomething("thread-1");
                }
                _1 = true;
            }
        }, "线程-1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100000000; i++) {
                    to.doSomething("thread-2");
                }
                _2 = true;
            }
        }, "线程-2");
        t1.start();
        t2.start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("嘟!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (_1 && _2) {
                        System.out.println(to);
                        break;
                    }
                }
            }
        }, "监测线程").start();

    }
}
