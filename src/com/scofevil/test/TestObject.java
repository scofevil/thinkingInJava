package com.scofevil.test;

public class TestObject {

    private volatile int count;

    public void doSomething(String threadName) {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return count + "";
    }

}
