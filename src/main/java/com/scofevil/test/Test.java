package com.scofevil.test;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class Test {
    public static void main(String[] args) throws Throwable {
        ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<>();
        for (int i = 0; i < 14; i++) {
            cm.put("key_" + i, "value_" + i);
        }
        test(1, 2);

    }

    static void test(int aaaaaaa, int bbbbbb) {
        aaaaaaa = aaaaaaa + 2;
        int ccccccccc = aaaaaaa + bbbbbb;
        System.out.println(ccccccccc);
        System.out.println(aaaaaaa);
        System.out.println(bbbbbb);
    }

}
