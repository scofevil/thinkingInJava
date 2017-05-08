package com.scofevil.test;


public class Test {
    public static void main(String[] args) {
        OOMObject o = new OOMObject();
        try {
            o.stackLeak();
        } catch (Exception e) {
            System.out.println(o.getStackLength());
            throw e;
        }
    }
}

class OOMObject {
    private int stackLength = 1;

    public void stackLeak() {
        setStackLength(getStackLength() + 1);
        stackLeak();
    }

    public int getStackLength() {
        return stackLength;
    }

    public void setStackLength(int stackLength) {
        this.stackLength = stackLength;
    }
}
