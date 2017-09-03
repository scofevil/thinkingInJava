package com.scofevil.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        int a = 1;
        int b = 2;
        System.out.println(i++ + ++i);
    }

}
