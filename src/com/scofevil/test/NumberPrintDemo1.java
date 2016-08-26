package com.scofevil.test;

public class NumberPrintDemo1 {

    static class PrintThread extends Thread {

        private static volatile int currentRun;

        private static volatile int currentNum = 0;

        private int                 current;

        static String               lock       = new String("lock");

        public PrintThread(int flag) {
            super("线程-" + flag);
            this.current = flag;
        }

        public void run() {
            do {
                System.out.println("正在等待的线程 " + current);
                synchronized (lock) {
                    System.out.println("线程" + current + " 获得lock");
                    if (currentRun == current) {
                        int i = 1;
                        while (i <= 5) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(super.getName() + " " + ++currentNum);
                            i++;
                        }
                        int tmp = currentNum;
                        if (tmp >= 75) {
                            currentRun = -1;
                        } else {
                            currentRun = ((tmp / 5) % 3) + 1;
                        }
                    }
                    System.out.println("线程" + current + " 释放lock");
                }
            } while (currentRun != -1);
        }
    }

    public static void main(String[] args) {
        PrintThread t1 = new PrintThread(1);
        PrintThread t2 = new PrintThread(2);
        PrintThread t3 = new PrintThread(3);
        PrintThread.currentRun = 1;
        t1.start();
        t2.start();
        t3.start();
    }
}
