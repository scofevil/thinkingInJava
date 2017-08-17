package com.scofevil.algorithm;

public class BinarySearch {

    int binary_search(int[] arr, int start, int end, int key) {
        if (start > end)
            return -1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (arr[m] == key)
                return m;
            if (arr[m] <= key)
                start = m + 1;
            else
                end = m - 1;
        }
        return -1;
    }

    int binary_serch_recursion(int[] arr, int start, int end, int key) {
        //        if (start > end)
        //            return -1;
        //        int m = (start + end) / 2;
        //        if (arr[m] == key)
        //            return m;
        //        if (start == end)
        //            return -1;
        //        if (arr[m] <= key)
        //            start = m + 1;
        //        else
        //            end = m - 1;
        //        return binary_search(arr, start, end, key);

        if (start > end)
            return -1;
        int mid = start + (end - start) / 2; //直接平均可能會溢位，所以用此算法
        if (arr[mid] > key)
            return binary_search(arr, start, mid - 1, key);
        if (arr[mid] < key)
            return binary_search(arr, mid + 1, end, key);
        return mid; //最後檢測相等是因為多數搜尋狀況不是大於要不就小於
    }

    public static void main(String[] args) {
        int arr[] = { 1, 100 };
        BinarySearch b = new BinarySearch();
        System.out.println(b.binary_serch_recursion(arr, 0, arr.length - 1, 100));
    }

}
