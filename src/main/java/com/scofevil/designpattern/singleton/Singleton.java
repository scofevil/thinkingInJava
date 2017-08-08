package com.scofevil.designpattern.singleton;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Singleton {

    //一个静态的实例
    private static Singleton singleton;

    //私有化构造函数
    private Singleton() {
    }

    //给出一个公共的静态方法返回一个单一实例
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
