package com.etc.ticket.service.impl;

import com.etc.ticket.dao.UserDao;
import com.etc.ticket.entity.User;
import com.etc.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public User queryUserByNameAndPwd(String name, String pwd) {
        return dao.queryUserByNameAndPwd(name,pwd);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }
}
