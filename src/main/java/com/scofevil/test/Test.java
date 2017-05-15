package com.scofevil.test;

import com.scofevil.test.enumt.Color;

public class Test {
    public static void main(String[] args) throws Throwable {

        Color.RED.test();
        Color.YELLOW.test();
        System.out.println(Color.YELLOW.getName());
    }
}
