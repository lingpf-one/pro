package com.etc.ticket.service.impl;

import com.etc.ticket.dao.PriceDao;
import com.etc.ticket.entity.Price;
import com.etc.ticket.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceDao dao;

    public PriceDao getDao() {
        return dao;
    }

    public void setDao(PriceDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Price> queryPriceBySessionId(Integer sessionid) {
        return dao.queryPriceBySessionId(sessionid);
    }

    @Override
    public Price queryPriceBySessionIdAndPrice(Double price, Integer sessionid) {
        return dao.queryPriceBySessionIdAndPrice(price,sessionid);
    }
}
