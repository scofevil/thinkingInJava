package com.scofevil.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2);
        System.out.println(li.hashCode());
        List<Integer> tmp = li;
        System.out.println(tmp);

        li = new ArrayList<>();
        System.out.println(li.hashCode());
        li.add(3);
        li.add(4);
        System.out.println(tmp);
    }

}
