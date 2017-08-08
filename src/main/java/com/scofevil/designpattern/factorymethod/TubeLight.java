package com.scofevil.designpattern.factorymethod;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class TubeLight implements Light {
    @Override
    public void turnOn() {
        System.out.println("TubeLight On");
    }

    @Override
    public void turnOff() {
        System.out.println("TubeLight Off");
    }
}
