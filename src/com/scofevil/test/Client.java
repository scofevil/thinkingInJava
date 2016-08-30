package com.scofevil.test;

public class Client {
    public static void main(String[] args) {
        Subject s = DynProxyFactory.getInstance();
        s.dealTask("1");
    }
}
