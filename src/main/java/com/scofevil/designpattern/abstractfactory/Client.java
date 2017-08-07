package com.scofevil.designpattern.abstractfactory;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        Creator c = new ConcreteCreator1();
        ProductA productA = c.createProductA();
        ProductB productB = c.createProductB();
        productA.methodA();
        
        productB.methodB();

        c = new ConcreteCreator2();
        productA = c.createProductA();
        productB = c.createProductB();
        productA.methodA();
        productB.methodB();
    }
}
