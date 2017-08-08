package com.scofevil.test.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        @SuppressWarnings("resource") ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "classpath:spring/ioc-test.xml");
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.addUser();
    }
}
