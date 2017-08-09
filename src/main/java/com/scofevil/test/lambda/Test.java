package com.scofevil.test.lambda;

import lombok.Data;

/**
 * @author haifeng.lu
 * @since 1.0
 */
@Data
public class Test {

    private String s;

    private int i = 3;

    public void test() {
        Add a = (x, y) -> x + y + this.i;
        System.out.println(a.add(1, 2));
    }

    public void test2(){
        Add a = (x, y) -> x + y + this.i;
        System.out.println(a.add(1,2));
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
        t.test2();
    }

    interface Add {
        int add(int x, int y);
    }

}
