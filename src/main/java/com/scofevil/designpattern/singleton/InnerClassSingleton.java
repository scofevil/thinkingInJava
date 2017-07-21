package com.scofevil.designpattern.singleton;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class InnerClassSingleton {

    public static Singleton getSingleton(){
        return Singleton.singleton;
    }

    private static class Singleton {
        protected static Singleton singleton = new Singleton();
    }

}
