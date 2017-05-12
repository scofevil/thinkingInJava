package com.scofevil.test.springioc.impl;

import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl {

    public void addUser() {
        System.out.println("add a user");
    }

    public void delUser() {

    }

    public void updateUser() {

    }

    public boolean hasUser(String user) {
        return false;
    }

}
