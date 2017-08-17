package com.scofevil.algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void bubble_sort(int arr[]) {
        int i, j, temp, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 5, 2, 6, 3, 6, 4, 7, 45, 7, 6, 7 };
        bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
