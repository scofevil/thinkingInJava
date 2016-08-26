package com.scofevil.test;

/**
 * @author 陆海峰
 * 原则是只需要保证两点即可(1).某一时刻只有一个线程在数；(2)这一段属于该线程数的范围。
 * 有以下三种实现方式，第三种还未实现。
 * 1.如只使用while(true) 和volatile；
 * 2.使用synchronize来同步；
 * 3.定向通知下一个符合条件的线程开始数数，避免竞争到锁但是条件不符合又放弃锁带来的性能损失。
 *
 */
public class NumberPrintDemo1 {

    static class PrintThread extends Thread {

        /**
         * 当前符合条件的线程
         */
        private static volatile int currentRun;

        /**
         * 当前数到的最后一个数
         */
        private static volatile int currentNum = 0;

        /**
         * 当前线程的编号，currentRun==current，该线程开始数
         */
        private int                 current;

        /**
         * 三个线程同步使用的锁，可以是任意的一把锁
         */
        static String               lock       = new String("lock");

        public PrintThread(int flag) {
            super("线程-" + flag);
            this.current = flag;
        }

        public void run() {
            do {
                System.out.println("正在等待锁的线程:线程" + current);
                synchronized (lock) {
                    System.out.println("线程" + current + "获得锁");
                    if (currentRun == current) {
                        System.out.println("线程" + current + "符合执行条件,开始数数:");
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
                    } else {
                        System.out.println("线程" + current + "暂时不符合执行条件,准备释放锁!");
                    }
                    System.out.println("线程" + current + "释放锁");
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
