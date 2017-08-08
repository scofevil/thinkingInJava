package com.scofevil.designpattern.abstractfactory;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class ConcreteCreator2 implements Creator {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
