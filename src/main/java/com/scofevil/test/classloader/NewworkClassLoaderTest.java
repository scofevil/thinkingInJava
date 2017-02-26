package com.scofevil.test.classloader;

import java.util.List;

public class NewworkClassLoaderTest {
    public static void main(String[] args) {
        try {
            //测试加载网络中的class文件  
            String rootUrl = "http://localhost:8080/classes";
            String className = "com.scofevil.test.classloader.NetClassLoaderSimple";
            NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
            NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
            Class<?> clazz1 = ncl1.loadClass(className);
            Class<?> clazz2 = ncl2.loadClass(className);
            System.out.println(clazz1.getClassLoader());
            System.out.println(clazz2.getClassLoader());
            System.out.println(List.class.getClassLoader());
            Object obj1 = clazz1.newInstance();
            Object obj2 = clazz2.newInstance();
            clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
