package com.scofevil.test;

public class Test {

    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("im running");
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("ending");
            }
            System.out.println("jieshu " + Thread.currentThread().isInterrupted());
        });
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        t.interrupt();
    }

}
