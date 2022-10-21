package com.etc.ticket.service;

import com.etc.ticket.entity.Price;

import java.util.List;

public interface PriceService {

    List<Price> queryPriceBySessionId(Integer sessionid);

    Price queryPriceBySessionIdAndPrice(Double price,Integer sessionid);
}
