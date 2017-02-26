package com.scofevil.test.superandsub;

public class SuperClass implements DosI {

    DoSomething ds;

    SuperClass(DoSomething ds) {
        this.ds = ds;
    }

    public void dos() {
        System.out.println("heihei");
    }

}
