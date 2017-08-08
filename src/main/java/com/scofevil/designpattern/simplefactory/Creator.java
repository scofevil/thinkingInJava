package com.scofevil.designpattern.simplefactory;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class Creator {

    private Creator() {
    }

    public static IProduct createProduct(String productName) {
        if (productName == null)
            return null;
        if (productName.equals("A"))
            return new ProductA();
        if (productName.equals("B"))
            return new ProductB();
        return null;
    }

}
