package com.scofevil.test.superandsub;

public class SubClass extends SuperClass {

    private String s;

    SubClass(String s) {
        super(new Dos());
        this.s = s;
    }

    public void dos() {
        super.ds.dosomething(this.s);
    }

    public static void main(String[] args) {

        /**
         *  子类覆盖了父类的方法，再用父类的引用调用此方法
         *  这时，实际调用的方法是你真实new 的那个对象的方法
         */
        DosI d = new SubClass("haha");
        d.dos();
        DosI d1 = new SuperClass(new Dos());
        d1.dos();
    }

}
