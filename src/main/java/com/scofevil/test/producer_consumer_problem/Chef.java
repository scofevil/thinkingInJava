package com.scofevil.test.producer_consumer_problem;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Chef implements Runnable {

    private Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                   while (restaurant.meal != null)
                        wait();//for the meal to be taken
                }
                if (++count == 10) {
                    System.out.println("Out of food,closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up!");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notify();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
