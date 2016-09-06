package com.scofevil.test;

public class Client {
    public static void main(String[] args) {
        String s1 = System.getProperty("java.security.manager");
        System.out.println(s1);
        Subject s = DynProxyFactory.getInstance();
        s.dealTask("1");
    }
}
