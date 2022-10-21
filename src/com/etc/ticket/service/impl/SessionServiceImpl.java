package com.etc.ticket.service.impl;

import com.etc.ticket.dao.SessionDao;

import com.etc.ticket.dto.MySessionDto;
import com.etc.ticket.entity.Session;
import com.etc.ticket.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDao dao;

    public SessionDao getDao() {
        return dao;
    }

    public void setDao(SessionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Session> querySessionForNumsNewsByType(Integer num, Integer type) {
        if(num==null||num<=0||type==null||type<=0){
            return null;
        }
        return dao.querySessionForNumsNewsByType(num,type);
    }

    @Override
    public MySessionDto querySessionById(Integer sessionid) {
        return dao.querySessionById(sessionid);
    }
}
