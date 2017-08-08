package com.scofevil.test.springioc;

import com.scofevil.test.springioc.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserManager {

    @Resource
    private UserDao userDao;

    public void addUser() {
        this.userDao.addUser();
    }

}
