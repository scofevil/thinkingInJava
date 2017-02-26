package com.scofevil.test.springioc;

public class UserDao implements UserDaoI {

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
