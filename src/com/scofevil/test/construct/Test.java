package com.scofevil.test.construct;

public class Test {

    public static void main(String[] args) {
        System.out.println("Test main() start");
        System.out.println("Two.i=" + Two.i);
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
