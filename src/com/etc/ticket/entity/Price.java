package com.etc.ticket.entity;

public class Price {
    private Integer price_id;
    private Double price_price;
    private Integer price_level;
    private Session price_session;

    public Integer getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Integer price_id) {
        this.price_id = price_id;
    }

    public Double getPrice_price() {
        return price_price;
    }

    public void setPrice_price(Double price_price) {
        this.price_price = price_price;
    }

    public Integer getPrice_level() {
        return price_level;
    }

    public void setPrice_level(Integer price_level) {
        this.price_level = price_level;
    }

    public Session getPrice_session() {
        return price_session;
    }

    public void setPrice_session(Session price_session) {
        this.price_session = price_session;
    }
}
