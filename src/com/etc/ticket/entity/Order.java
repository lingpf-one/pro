package com.etc.ticket.entity;

public class Order {
    private Integer order_id;
    private String order_time;
    private User order_user;
    private String order_price; // 价格主键id_数量&价格主键_数量
    private String order_status;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public User getOrder_user() {
        return order_user;
    }

    public void setOrder_user(User order_user) {
        this.order_user = order_user;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
