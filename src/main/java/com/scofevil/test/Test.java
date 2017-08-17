package com.scofevil.test;

import com.scofevil.test.lambda.TestExtends;
import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class Test {
    public static void main(String[] args) throws Throwable {
        final  ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i=0; i<16; i++){
            concurrentHashMap.put("key_" +i,"value_" +i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=10;i<1000;i++){
                    concurrentHashMap.put("key_" +i,"value_" +i);
                }
            }
        }).start();

        System.out.println(concurrentHashMap);
    }

    static void test(int aaaaaaa, int bbbbbb) {
        aaaaaaa = aaaaaaa + 2;
        int ccccccccc = aaaaaaa + bbbbbb;
        System.out.println(ccccccccc);
        System.out.println(aaaaaaa);
        System.out.println(bbbbbb);
    }

}
