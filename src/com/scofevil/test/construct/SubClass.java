package com.scofevil.test.construct;

public class SubClass extends SuperClass {
    SubClass(String str) {
        super(str);
        System.out.println("Sub with string");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        SubClass sub = new SubClass("sub");
    }
}

class SuperClass {
    //SuperClass() {
    //}

    SuperClass(String str) {
        System.out.println("Super with a string");
    }
}
