package com.scofevil.test.executor;

import com.google.common.base.Stopwatch;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Test {

    static class Task implements Runnable {

        int i;

        Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Stopwatch stopWatch = Stopwatch.createStarted();
                System.out.println("[" + this.i + "] start....");
                Thread.sleep((int) (Math.random() * 10000));
                System.out.println(
                        "[" + this.i + "] cost=" + stopWatch.elapsed(TimeUnit.SECONDS) + " end.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class LashiTask implements Runnable {

        private Semaphore     semaphore;
        private int           index;
        private ReentrantLock lock;

        LashiTask(int index, Semaphore semaphore) {
            this.index = index;
            this.semaphore = semaphore;
        }

        LashiTask(int index, ReentrantLock reentrantLock) {
            this.index = index;
            this.lock = reentrantLock;
        }

        @Override
        public void run() {
            Stopwatch stopWatch = Stopwatch.createStarted();
            String name = "顾客[" + index + "]";
            System.out.println(name + "开始等待厕所空位 当前时间:" + new Date());
            try {
                lock.lock();
                Thread.sleep(5000);
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + "上厕所完毕,当前时间=" + new Date() + "等待+如厕时间总共" + stopWatch
                        .elapsed(TimeUnit.SECONDS) + "秒");
            }
        }
    }

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1500);
        for (int i = 0; i < 1500; i++) {
            es.execute(() -> {
                for(int j=0;j<1000;j++){
                    count.addAndGet(1);
                }
            });
        }

        Thread.sleep(3000);
        System.out.println(count);
    }

}
