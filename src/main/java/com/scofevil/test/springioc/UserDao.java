package com.scofevil.test.springioc;

public interface UserDao {
    /**
     * 添加用户
     */
    void addUser();

    /**
     * 删除用户
     */
    void delUser();

    /**
     * 更新用户
     */
    void updateUser();

    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    boolean hasUser(String user);
}
