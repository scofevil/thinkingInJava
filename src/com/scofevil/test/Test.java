package com.scofevil.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author haifeng.lu
 * 测试ConcurrentModificationException
 * modCount != expectedModCount
 */
public class Test {
    private String t;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Test(String t) {
        this.t = t;
    }

    public static void main(String[] args) {
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test("1"));
        list.add(new Test("2"));
        list.add(new Test("3"));
        list.add(new Test("4"));
        list.add(new Test("5"));
        Iterator<Test> iterator = list.iterator();
        Test[] tmp2 = { new Test("t") };
        Object[] tmp = list.toArray();
        Test[] tmp1 = list.toArray(tmp2);
        Consumer<Test> action = new Consumer<Test>() {
            public void accept(Test t) {
                t.setT("0");
                //把遥控器砸了，但是电视机还在，持有电视机的list中还有指向电视机的遥控器
                t = null;
            }
        };
        iterator.forEachRemaining(action);
        System.out.println(tmp);
        System.out.println(tmp1);
        while (iterator.hasNext()) {
            Test t = iterator.next();
            System.out.println(t);
            //            list.remove(t);
        }
    }

    public String toString() {
        return t;
    }
}
