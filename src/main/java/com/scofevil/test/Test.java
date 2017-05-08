package com.scofevil.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Throwable {

        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM了  
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

class OOMObject {

}
