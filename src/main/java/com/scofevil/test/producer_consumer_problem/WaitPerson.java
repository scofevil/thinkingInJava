package com.scofevil.test.producer_consumer_problem;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    /**
                     * 这里用while是因为可以在等待结束回到此位置继续执行时，再进行判断条件是否满足，如果不满足会继续调用wait()
                     */
                    while (restaurant.meal == null)
                        wait();// for the chef to produce meal
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("waitperson interrupted");
        }
    }
}
