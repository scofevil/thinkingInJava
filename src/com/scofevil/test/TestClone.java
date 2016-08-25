package com.scofevil.test;

public class TestClone {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.setCount(1);
        c1.setName("1");
        c1.setC(new Counter(2, "2"));
        Counter c2 = c1.clone();
        c2.getC().setCount(3);
        c2.setName("4");
        System.out.println(c1 == c2);
    }

}
