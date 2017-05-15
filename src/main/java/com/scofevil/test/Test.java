package com.scofevil.test;

import java.util.EnumMap;

import com.scofevil.test.enumt.Color;

public class Test {
    public static void main(String[] args) throws Throwable {

        EnumMap<Color, String> map = new EnumMap<Color, String>(Color.class);
        map.put(Color.GREEN, "green");
        System.out.println(map);
    }
}
