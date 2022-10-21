package com.etc.ticket.service.impl;

import com.etc.ticket.dao.ShopCarDao;
import com.etc.ticket.dto.ShopCarDto;
import com.etc.ticket.entity.ShopCar;
import com.etc.ticket.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarDao dao ;

    public ShopCarDao getDao() {
        return dao;
    }

    public void setDao(ShopCarDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ShopCar> queryNumByUseridAndStatus(Integer user_id, String status) {
        return dao.queryNumByUseridAndStatus(user_id,status);
    }

    @Override
    public boolean addShopCar(ShopCarDto dto) {
        return dao.addShopCar(dto);
    }
}
