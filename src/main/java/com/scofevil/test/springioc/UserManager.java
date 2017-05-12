package com.scofevil.test.springioc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scofevil.test.springioc.impl.UserDaoImpl;

@Service
public class UserManager {

    @Resource
    private UserDaoImpl userDaoImpl;

    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void addUser() {
        this.userDaoImpl.addUser();
    }

}
