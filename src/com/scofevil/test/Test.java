package com.scofevil.test;

public class Test {
    static Object s     = new Object();
    static int    count = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {

            public void run() {
                for (int i = 1; i <= 1000; i++) {

                    synchronized (s) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count++);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for (int i = 1; i <= 1000; i++) {

                    synchronized (s) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count++);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for (int i = 1; i <= 1000; i++) {

                    synchronized (s) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count++);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for (int i = 1; i <= 1000; i++) {

                    synchronized (s) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count++);
                    }
                }
            }
        }).start();
    }
}
