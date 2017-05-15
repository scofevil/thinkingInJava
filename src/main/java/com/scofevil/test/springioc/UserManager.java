package com.scofevil.test.springioc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scofevil.test.springioc.dao.UserDao;

@Service
public class UserManager {

    @Resource
    private UserDao userDao;

    public void addUser() {
        this.userDao.addUser();
    }

}
