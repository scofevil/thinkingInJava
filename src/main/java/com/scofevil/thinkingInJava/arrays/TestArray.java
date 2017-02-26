package com.scofevil.thinkingInJava.arrays;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        //        BerylliumSphere[] spheres = new BerylliumSphere[10];
        //        for (int i = 0; i < 5; i++) {
        //            System.out.println(BerylliumSphere.counter);
        //            spheres[i] = new BerylliumSphere();
        //        }
        //        System.out.println((Arrays.toString(spheres)));
        //        System.out.println(spheres[4]);
        //        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        //        for (int i = 0; i < 5; i++)
        //            sphereList.add(new BerylliumSphere());
        //        System.out.println(sphereList);
        //        System.out.println(sphereList.get(4));

        //        List<Integer>[] li = new ArrayList<Integer>[12];

        int array1[] = { 1, 2, 3, 4, 5 };
        int array1c[] = clone(array1);
        array1c[3] = 1;
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array1c));
        //int array2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //        System.out.println("Original size: " + array1.length);
        //        System.out.println("New size: " + doubleArray(array1).length);
        //        System.out.println("Original size: " + array2.length);
        //        System.out.println("New size: " + doubleArray(array2).length);
    }

    static int[] doubleArray(int original[]) {
        int length = original.length;
        int newArray[] = new int[length * 2];
        System.arraycopy(original, 0, newArray, 0, length);
        return newArray;
    }

    static int[] clone(int original[]) {
        return original.clone();

    }
}
