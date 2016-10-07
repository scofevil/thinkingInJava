package com.scofevil.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        String s = "d";
        String b = s.intern();
    }
}
