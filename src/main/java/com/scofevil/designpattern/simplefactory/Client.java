package com.scofevil.designpattern.simplefactory;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        IProduct product1 = Creator.createProduct("A");
        product1.method();
        IProduct product2 = Creator.createProduct("B");
        product2.method();
    }
}
