package com.scofevil.test.springioc.impl;

import com.scofevil.test.springioc.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {

    public void addUser() {
        System.out.println("add a user");
    }
}
