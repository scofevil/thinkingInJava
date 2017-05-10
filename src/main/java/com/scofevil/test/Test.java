package com.scofevil.test;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) throws Throwable {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("!!");
            }
        };

        TimerTask timerTask1 = new TimerTask() {

            @Override
            public void run() {
                System.out.println("??");
            }
        };
        TimerTask timerTask2 = new TimerTask() {

            @Override
            public void run() {
                System.out.println("??!!");
            }
        };
        Timer timer2 = new Timer();
        timer.schedule(timerTask, 3000, 3000);
        timer.schedule(timerTask1, 3000, 3000);
        timer2.schedule(timerTask2, 3000, 4000);

    }
}

class OOMObject {

}
