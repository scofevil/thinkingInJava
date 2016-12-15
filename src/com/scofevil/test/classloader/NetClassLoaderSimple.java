package com.scofevil.test.classloader;

public class NetClassLoaderSimple {
    private NetClassLoaderSimple instance;

    static {
        System.out.println("aaaa");
    }

    public void setNetClassLoaderSimple(Object obj) {
        this.instance = (NetClassLoaderSimple) obj;
    }
}
