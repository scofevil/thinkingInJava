package com.scofevil.test;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(T.class.getClassLoader());
        System.out.println(T.l);
        T t = new T("t");
    }
}

class T {
    static {
        System.out.println("init");
    }
    public static final List l = null;

    public T(String s) {
        System.out.println(s);
    }
}