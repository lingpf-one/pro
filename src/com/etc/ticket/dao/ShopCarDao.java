package com.etc.ticket.dao;

import com.etc.ticket.dto.ShopCarDto;
import com.etc.ticket.entity.ShopCar;

import java.util.List;

public interface ShopCarDao {

     List<ShopCar> queryNumByUseridAndStatus(Integer user_id, String status);

     boolean addShopCar(ShopCarDto dto);
}
