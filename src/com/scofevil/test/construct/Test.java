package com.scofevil.test.construct;

public class Test {

    static {
        System.out.println("forName");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.scofevil.test.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class One {
    static Two two_1 = new Two("Two-1");

    One(String str) {
        System.out.println(str);
    }
}

class Two {

    static int i     = 0;
    One        one_1 = new One("one-1");
    static One one_2 = new One("one-2");
    static One one_3 = new One("one-3");

    Two(String str) {
        System.out.println(str);
    }
}
