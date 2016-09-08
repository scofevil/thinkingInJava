package com.scofevil.test;

import java.util.ArrayList;
import java.util.Collection;
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

    static class MyC<E> implements Collection<E> {

        public int size() {
            // TODO Auto-generated method stub
            return 0;
        }

        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean contains(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        public Iterator<E> iterator() {
            // TODO Auto-generated method stub
            return null;
        }

        public Object[] toArray() {

            return new Test[1];
        }

        public <T> T[] toArray(T[] a) {
            // TODO Auto-generated method stub
            return null;
        }

        public boolean add(E e) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean remove(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean addAll(Collection<? extends E> c) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean removeAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean retainAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        public void clear() {
            // TODO Auto-generated method stub

        }

    }

    public static void main(String[] args) {
        String s = null;
        assert s != null;
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test("1"));
        list.add(new Test("2"));
        list.add(new Test("3"));
        list.add(new Test("4"));
        list.add(new Test("5"));
        Object[] a = new Object[3];
        System.out.println(a.length);
        Test[] ttt = new Test[3];
        a = ttt;
        a[0] = new Object();
        System.out.println(a);
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
