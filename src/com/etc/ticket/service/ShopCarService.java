package com.etc.ticket.service;

import com.etc.ticket.dto.ShopCarDto;
import com.etc.ticket.entity.ShopCar;

import java.util.List;

public interface ShopCarService {

    List<ShopCar> queryNumByUseridAndStatus(Integer user_id, String status);
    boolean addShopCar(ShopCarDto dto);
}
