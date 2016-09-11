package com.scofevil.test.springioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    private static UserDaoI userDaoI;

    public static void main(String[] args) {
        BeanFactory factory = new FileSystemXmlApplicationContext("classpath:ioc-test.xml");
        UserManager userManager = (UserManager) factory.getBean("userManager");
        userManager.addUser();
    }
}
