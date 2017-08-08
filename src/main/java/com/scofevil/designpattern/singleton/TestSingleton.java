package com.scofevil.designpattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class TestSingleton {

    private volatile boolean lock;

    public static void main(String[] args) throws InterruptedException {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
        final TestSingleton lock = new TestSingleton();
        lock.setLock(true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (!lock.isLock()) {
                            Singleton singleton = Singleton.getSingleton();
                            instanceSet.add(singleton.toString());
                        }
                    }
                }
            });
        }
        Thread.sleep(2000);
        lock.setLock(false);
        Thread.sleep(2000);
        System.out.println("---------并发情况下我们取到的实例----------");
        for (String each : instanceSet) {
            System.out.println(each);
        }
        executorService.shutdown();
        System.exit(0);
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }
}
