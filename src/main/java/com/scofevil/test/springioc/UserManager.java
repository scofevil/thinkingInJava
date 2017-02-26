package com.scofevil.test.springioc;

public class UserManager {

    private UserDaoI userDaoI;

    public void addUser() {
        this.userDaoI.addUser();
    }

    public UserDaoI getUserDao() {
        return userDaoI;
    }

    public void setUserDaoI(UserDaoI userDao) {
        this.userDaoI = userDao;
    }
}
