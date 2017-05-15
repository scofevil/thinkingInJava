package com.scofevil.test.springioc.dao;

import org.springframework.stereotype.Service;

@Service
public interface UserDao {
    /**
     * 添加用户
     */
    void addUser();

}
