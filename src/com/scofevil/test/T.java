package com.scofevil.test;

public class T<T> {
    static int i = 1;
    T          t;
    static {
        i = 2;
    }

    public T() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }

    public static void main(String[] args) {
    }
}
