package com.scofevil.test.testinterface;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class C extends B {

    public static void main(String[] args) {
        C c = new C();
        c.a();
        c.b();
        A a = c;
        a.a();
    }
}
