package com.etc.ticket.service;

import com.etc.ticket.entity.User;

public interface UserService {

    boolean addUser(User user);

    User queryUserByNameAndPwd(String name ,String pwd);

    boolean updateUser(User user);
}
