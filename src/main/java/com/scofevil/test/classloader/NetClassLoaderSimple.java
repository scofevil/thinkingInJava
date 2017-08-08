package com.scofevil.test.classloader;

public class NetClassLoaderSimple {
    static {
        System.out.println("aaaa");
    }

    private NetClassLoaderSimple instance;

    public void setNetClassLoaderSimple(Object obj) {
        this.instance = (NetClassLoaderSimple) obj;
    }
}
