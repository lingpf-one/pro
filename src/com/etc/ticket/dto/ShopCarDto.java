package com.etc.ticket.dto;

import com.etc.ticket.entity.Price;
import com.etc.ticket.entity.User;

public class ShopCarDto {
    private Integer shopcar_id;
    private Integer shopcar_user;
    private Integer shopcar_price;
    private Integer shopcar_num;
    private String shopcar_status;

    public Integer getShopcar_id() {
        return shopcar_id;
    }

    public void setShopcar_id(Integer shopcar_id) {
        this.shopcar_id = shopcar_id;
    }

    public Integer getShopcar_user() {
        return shopcar_user;
    }

    public void setShopcar_user(Integer shopcar_user) {
        this.shopcar_user = shopcar_user;
    }

    public Integer getShopcar_price() {
        return shopcar_price;
    }

    public void setShopcar_price(Integer shopcar_price) {
        this.shopcar_price = shopcar_price;
    }

    public Integer getShopcar_num() {
        return shopcar_num;
    }

    public void setShopcar_num(Integer shopcar_num) {
        this.shopcar_num = shopcar_num;
    }

    public String getShopcar_status() {
        return shopcar_status;
    }

    public void setShopcar_status(String shopcar_status) {
        this.shopcar_status = shopcar_status;
    }
}
