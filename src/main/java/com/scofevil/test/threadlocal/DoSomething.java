package com.scofevil.test.threadlocal;

public class DoSomething implements Runnable {

    private static ThreadLocal<String> name = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };
    private static ThreadLocal<String> name1 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };
    private static ThreadLocal<String> name2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    //    private String name = Thread.currentThread().getName();

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t);
            System.out.println(name.get() + " " + +i);
            System.out.println(name1.get() + " " + +i);
            System.out.println(name2.get() + " " + +i);
        }
    }
}
