package com.scofevil.thinkingInJava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            System.out.println(BerylliumSphere.counter);
            spheres[i] = new BerylliumSphere();
        }
        System.out.println((Arrays.toString(spheres)));
        System.out.println(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++)
            sphereList.add(new BerylliumSphere());
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        //        List<Integer>[] li = new ArrayList<Integer>[12];
    }
}
