package com.scofevil.test.springioc;

import lombok.Data;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Data
public class Test {
    @SuppressWarnings("unused")
    private static UserDaoI userDaoI;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        BeanFactory factory = new FileSystemXmlApplicationContext("classpath:ioc-test.xml");
        UserManager userManager = (UserManager) factory.getBean("userManager");
        userManager.addUser();
    }
}