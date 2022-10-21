package com.etc.ticket.dao;

import com.etc.ticket.entity.User;

public interface UserDao {

    boolean addUser(User user);

    User queryUserByNameAndPwd(String name ,String pwd);


    boolean updateUser(User user);

}
