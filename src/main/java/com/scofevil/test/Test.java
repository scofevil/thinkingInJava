package com.scofevil.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread t = new Thread(() -> {
            lock.lock();
            System.out.println("thread start");
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("thread end");
        },"tttttt");
        executorService.execute(t);
        Thread.sleep(3000);
        System.out.println("end");
    }

}
