package com.scofevil.designpattern.factorymethod;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class BuldLight implements Light {
    @Override
    public void turnOn() {
        System.out.println("BuldLight On");
    }

    @Override
    public void turnOff() {
        System.out.println("BuldLight Off");
    }
}
