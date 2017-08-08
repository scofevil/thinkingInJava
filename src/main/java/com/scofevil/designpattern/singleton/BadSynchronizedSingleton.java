package com.scofevil.designpattern.singleton;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class BadSynchronizedSingleton {

    //一个静态的实例
    private static BadSynchronizedSingleton badSynchronizedSingleton;

    //私有化构造函数
    private BadSynchronizedSingleton() {
    }

    //给出一个公共的静态方法返回一个单一实例
    public static synchronized BadSynchronizedSingleton getBadSynchronizedSingleton() {
        if (badSynchronizedSingleton == null) {
            badSynchronizedSingleton = new BadSynchronizedSingleton();
        }
        return badSynchronizedSingleton;
    }
}
