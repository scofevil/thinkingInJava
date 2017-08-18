package com.scofevil.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread t = new Thread(() -> {
            System.out.println("thread start");
            System.out.println("thread end");
        },"tttttt");
        executorService.execute(t);
        t.join();
        Thread.sleep(3000);
        t.interrupt();
        System.out.println("end");
    }

}
