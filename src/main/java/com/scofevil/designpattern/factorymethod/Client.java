package com.scofevil.designpattern.factorymethod;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new BuldCreator();
        Light light = creator.createLight();
        light.turnOff();
        light.turnOn();

        creator = new TubeCreator();
        light = creator.createLight();
        light.turnOn();
        light.turnOff();
    }
}
