package com.scofevil.test.springioc.impl;

import org.springframework.stereotype.Service;

import com.scofevil.test.springioc.dao.UserDao;

@Service
public class UserDaoImpl implements UserDao {

    public void addUser() {
        System.out.println("add a user");
    }
}
