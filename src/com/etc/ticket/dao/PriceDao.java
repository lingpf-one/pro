package com.etc.ticket.dao;

import com.etc.ticket.entity.Price;

import java.util.List;

public interface PriceDao {

    List<Price> queryPriceBySessionId(Integer sessionid);

    Price queryPriceBySessionIdAndPrice(Double price,Integer sessionid);
}
