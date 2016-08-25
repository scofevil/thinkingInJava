package com.scofevil.test;

public class Counter implements Cloneable {
    private int     count;
    private String  name;
    private Counter c;

    public Counter() {

    }

    public Counter(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counter clone() {
        Counter o = new Counter();
        try {
            o = (Counter) super.clone();
            o.setC((Counter) c.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public Counter getC() {
        return c;
    }

    public void setC(Counter c) {
        this.c = c;
    }
}
