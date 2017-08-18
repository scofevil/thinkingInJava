package com.scofevil.test;

public class Test {

    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!flag) {
                System.out.println("im running");
                try {
                    Thread.sleep(50000000);
                } catch (InterruptedException e) {
                    System.out.println("im interupted");
                }
                System.out.println("ending");
            }
        });
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        t.interrupt();
    }

}
