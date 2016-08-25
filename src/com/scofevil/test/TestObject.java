package com.scofevil.test;

public class TestObject {

    private int count;

    public synchronized void doSomething(String threadName) {
        System.out.println(threadName + " dosomething! and this moment count = " + count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
