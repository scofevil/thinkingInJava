package com.scofevil.designpattern.factorymethod;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class TubeCreator implements Creator{
    @Override
    public Light createLight() {
        return new TubeLight();
    }
}
