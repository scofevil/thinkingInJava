package com.scofevil.test;

public class Test {
    public static void main(String[] args) throws Throwable {
        OOMObject o = new OOMObject();
        try {
            o.newthreadRun();
        } catch (Exception e) {
        }
    }
}

class OOMObject {
    private int i = 1;

    private void oRun() {
        while (true) {

        }
    }

    public int newthreadRun() {
        while (true) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    oRun();
                }
            });
            System.out.println(i++);
            t.start();
        }
    }

}
