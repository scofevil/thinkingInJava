package com.scofevil.designpattern.singleton;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Singleton1 {

    private static Singleton1 ourInstance = new Singleton1();

    public static Singleton1 getInstance() {
        return ourInstance;
    }

    private Singleton1() {
    }
}
