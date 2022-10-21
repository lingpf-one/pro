package com.etc.ticket.service;

import com.etc.ticket.dto.MySessionDto;
import com.etc.ticket.entity.Session;

import java.util.List;

public interface SessionService {

    List<Session> querySessionForNumsNewsByType(Integer num, Integer type);

    MySessionDto querySessionById(Integer sessionid);

}
