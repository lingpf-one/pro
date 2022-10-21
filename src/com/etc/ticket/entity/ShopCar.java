package com.etc.ticket.entity;

public class ShopCar {
    private Integer shopcar_id;
    private User shopcar_user;
    private Price shopcar_price;
    private Integer shopcar_num;
    private String shopcar_status;

    public Integer getShopcar_id() {
        return shopcar_id;
    }

    public void setShopcar_id(Integer shopcar_id) {
        this.shopcar_id = shopcar_id;
    }

    public User getShopcar_user() {
        return shopcar_user;
    }

    public void setShopcar_user(User shopcar_user) {
        this.shopcar_user = shopcar_user;
    }

    public Price getShopcar_price() {
        return shopcar_price;
    }

    public void setShopcar_price(Price shopcar_price) {
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
