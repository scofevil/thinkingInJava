package com.scofevil.test.producer_consumer_problem;

import lombok.Data;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
@Data
public class Meal {

    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal_" + orderNum;
    }
}
